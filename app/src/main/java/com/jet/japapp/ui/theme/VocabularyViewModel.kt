package com.example.yourappname

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// A generic data class to hold the state for any checklist
data class ProgressTrackerState(
    val key: String, // Unique key for saving progress (e.g., "minna_progress")
    val title: String,
    val lessons: List<VocabLesson>,
    val completedLessonIds: Set<String> = emptySet(),
    val progress: Float = 0f,
    val progressText: String = ""
)

// The main UI state now holds a list of these trackers
data class VocabularyUiState(
    val trackers: List<ProgressTrackerState> = emptyList()
)

class VocabularyViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(VocabularyUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAllProgress()
    }

    private fun loadAllProgress() {
        val minnaTracker = createTracker("minna_progress", "JLPT N5 Vocab", getMinnaNoNihongoLessons())
        val verbTracker = createTracker("verb_progress", "Verb Practice", getVerbPracticeLessons())
        val nounTracker = createTracker("noun_progress", "Noun Practice", getNounPracticeLessons())
        val flashcardTracker = createTracker("flashcard_progress", "Vocab Flashcards", getFlashcardLessons())

        _uiState.value = VocabularyUiState(
            trackers = listOf(minnaTracker, verbTracker, nounTracker, flashcardTracker)
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
            // Find the tracker that needs to be updated
            val oldTracker = _uiState.value.trackers.find { it.key == trackerKey } ?: return@launch
            val currentCompleted = oldTracker.completedLessonIds.toMutableSet()

            if (isChecked) {
                currentCompleted.add(lessonId)
            } else {
                currentCompleted.remove(lessonId)
            }

            // Save the new progress
            ScorePersistence.saveProgress(getApplication(), trackerKey, currentCompleted)

            // Create the updated tracker
            val newTracker = createTracker(oldTracker.key, oldTracker.title, oldTracker.lessons)

            // Update the list of trackers in the UI state
            _uiState.update { currentState ->
                currentState.copy(
                    trackers = currentState.trackers.map { if (it.key == trackerKey) newTracker else it }
                )
            }
        }
    }
}