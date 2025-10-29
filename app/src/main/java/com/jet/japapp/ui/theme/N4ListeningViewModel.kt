package com.example.yourappname

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// We reuse the ListeningUiState as it fits our needs perfectly
class N4ListeningViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(ListeningUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAllProgress()
    }

    private fun loadAllProgress() {
        // Create trackers for the new N4 sections
        val startTracker = createTracker("n4_listen_start_progress", "N4 Listening (Start with these)", getN4ListeningStartLessons())
        val practiceTracker = createTracker("n4_listen_practice_progress", "N4 Listening #2", getN4ListeningPracticeLessons())

        // Reuse the channel list from the N5 data file as requested
        val channels = getListeningChannels()

        _uiState.value = ListeningUiState(
            trackers = listOf(startTracker, practiceTracker),
            channels = channels
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