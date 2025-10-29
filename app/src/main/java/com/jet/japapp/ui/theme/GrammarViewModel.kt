package com.example.yourappname

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// We reuse the same state holders from the Vocabulary feature.
class GrammarViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(VocabularyUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAllProgress()
    }

    private fun loadAllProgress() {
        val grammarTracker = createTracker("grammar_main_progress", "JLPT N5 Grammar", getGrammarLessons())
        val practiceTracker = createTracker("grammar_practice_progress", "Grammar Practice", getGrammarPracticeLessons())
        val oneShotTracker = createTracker("grammar_oneshot_progress", "1-Shot Grammar(before exam)", getOneShotLessons())

        _uiState.value = VocabularyUiState(
            trackers = listOf(grammarTracker, practiceTracker, oneShotTracker)
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