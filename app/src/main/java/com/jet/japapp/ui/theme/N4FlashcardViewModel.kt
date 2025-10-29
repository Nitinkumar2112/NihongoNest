package com.example.yourappname

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

// We reuse the FlashcardUiState data class
class N4FlashcardViewModel(application: Application) : AndroidViewModel(application) {
    private val _uiState = MutableStateFlow(FlashcardUiState())
    val uiState = _uiState.asStateFlow()

    fun loadSet(set: FlashcardSet) {
        val (known, unknown) = ScorePersistence.getFlashcardProgress(getApplication(), set.id)
        _uiState.value = FlashcardUiState(
            currentSet = set,
            knownWords = known,
            unknownWords = unknown
        )
    }

    fun onFlipCard() {
        _uiState.update { it.copy(isFlipped = !it.isFlipped) }
    }

    fun onNextCard() {
        val setSize = _uiState.value.currentSet?.cards?.size ?: 0
        if (setSize > 0) {
            val nextIndex = (_uiState.value.currentIndex + 1)
            if (nextIndex < setSize) {
                _uiState.update { it.copy(currentIndex = nextIndex, isFlipped = false) }
            } else {
                _uiState.update { it.copy(showResultsDialog = true) }
            }
        }
    }

    fun onPreviousCard() {
        if (_uiState.value.currentIndex > 0) {
            _uiState.update { it.copy(currentIndex = it.currentIndex - 1, isFlipped = false) }
        }
    }

    fun onMarkWord(isKnown: Boolean) {
        val currentCard = _uiState.value.currentSet?.cards?.getOrNull(_uiState.value.currentIndex) ?: return
        val newKnown = _uiState.value.knownWords.toMutableSet()
        val newUnknown = _uiState.value.unknownWords.toMutableSet()

        if (isKnown) {
            newKnown.add(currentCard.japanese)
            newUnknown.remove(currentCard.japanese)
        } else {
            newUnknown.add(currentCard.japanese)
            newKnown.remove(currentCard.japanese)
        }

        _uiState.update { it.copy(knownWords = newKnown, unknownWords = newUnknown) }
        saveProgress()
        onNextCard()
    }

    fun dismissResultsDialog() {
        _uiState.update { it.copy(showResultsDialog = false) }
    }

    private fun saveProgress() {
        val setId = _uiState.value.currentSet?.id ?: return
        ScorePersistence.saveFlashcardProgress(getApplication(), setId, _uiState.value.knownWords, _uiState.value.unknownWords)
    }
}