package com.example.yourappname

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

// This class will hold the state for the Dictionary UI
sealed class DictionaryUiState {
    data object Idle : DictionaryUiState()
    data object Loading : DictionaryUiState()
    data class Success(val results: List<JishoResult>) : DictionaryUiState()
    data class Error(val message: String) : DictionaryUiState()
}

class DictionaryViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<DictionaryUiState>(DictionaryUiState.Idle)
    val uiState = _uiState.asStateFlow()

    fun searchWord(query: String) {
        if (query.isBlank()) {
            _uiState.value = DictionaryUiState.Idle
            return
        }
        _uiState.value = DictionaryUiState.Loading
        viewModelScope.launch {
            val results = DictionaryService.searchWord(query)
            if (results.isNotEmpty()) {
                _uiState.value = DictionaryUiState.Success(results)
            } else {
                _uiState.value = DictionaryUiState.Error("No results found or error.")
            }
        }
    }
}