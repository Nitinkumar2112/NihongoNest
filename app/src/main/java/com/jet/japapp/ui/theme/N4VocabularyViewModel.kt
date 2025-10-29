package com.example.yourappname

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// We can reuse the VocabularyUiState from the N5 screen
class N4VocabularyViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(VocabularyUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAllProgress()
    }

    private fun loadAllProgress() {
        val vocabTracker = createTracker("n4_vocab_progress", "JLPT N4 Vocab", getN4VocabLessons())
        val verbTracker = createTracker("n4_verb_progress", "Verb Practice", getN4VerbLessons())
        val nounTracker = createTracker("n4_noun_progress", "Noun Practice", getN4NounLessons())
        val adjectiveTracker = createTracker("n4_adj_progress", "Adjective Practice", getN4AdjectiveLessons())

        _uiState.value = VocabularyUiState(
            trackers = listOf(vocabTracker, verbTracker, nounTracker, adjectiveTracker)
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