package com.example.yourappname

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// We reuse the VocabularyUiState from the N5 screen.
class N4KanjiViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(VocabularyUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAllProgress()
    }

    private fun loadAllProgress() {
        val kanjiTracker = createTracker("n4_kanji_progress", "N-4 Kanji", getN4KanjiLessons())
        val readingTracker = createTracker("n4_kanji_reading_progress", "N-4 Kanji Reading Practice", getN4KanjiReadingPractice())
        val practiceTracker = createTracker("n4_kanji_test_progress", "N-4 Kanji Practice Test", getN4KanjiPracticeTest())

        _uiState.value = VocabularyUiState(
            trackers = listOf(kanjiTracker, readingTracker, practiceTracker)
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