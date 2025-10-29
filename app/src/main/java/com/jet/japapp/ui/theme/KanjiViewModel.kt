package com.example.yourappname

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// We can reuse the ProgressTrackerState and VocabularyUiState data classes
// No need to redefine them if they are in the same package.

class KanjiViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(VocabularyUiState()) // Reusing the state holder
    val uiState = _uiState.asStateFlow()

    init {
        loadAllProgress()
    }

    private fun loadAllProgress() {
        val hindiTracker = createTracker("kanji_hindi_progress", "N-5 Kanji (Hindi)", getKanjiHindiLessons())
        val englishTracker = createTracker("kanji_english_progress", "N-5 Kanji (English)", getKanjiEnglishLessons())
        val practiceTracker = createTracker("kanji_practice_progress", "N-5 Kanji Practice Test", getKanjiPracticeLessons())

        _uiState.value = VocabularyUiState(
            trackers = listOf(hindiTracker, englishTracker, practiceTracker)
        )
    }

    private fun createTracker(key: String, title: String, lessons: List<VocabLesson>): ProgressTrackerState {
        val completedIds = ScorePersistence.getProgress(getApplication(), key)
        val progress = if (lessons.isNotEmpty()) completedIds.size.toFloat() / lessons.size.toFloat() else 0f
        val progressText = "${completedIds.size} / ${lessons.size}"
        return ProgressTrackerState(key, title, lessons, completedIds, progress, progressText)
    }

    fun onLessonToggled(trackerKey: String, lessonId: String, isChecked: Boolean) {
        viewModelScope.launch {
            val oldTracker = _uiState.value.trackers.find { it.key == trackerKey } ?: return@launch
            val currentCompleted = oldTracker.completedLessonIds.toMutableSet()

            if (isChecked) {
                currentCompleted.add(lessonId)
            } else {
                currentCompleted.remove(lessonId)
            }

            ScorePersistence.saveProgress(getApplication(), trackerKey, currentCompleted)
            val newTracker = createTracker(oldTracker.key, oldTracker.title, oldTracker.lessons)

            _uiState.update { currentState ->
                currentState.copy(
                    trackers = currentState.trackers.map { if (it.key == trackerKey) newTracker else it }
                )
            }
        }
    }
}