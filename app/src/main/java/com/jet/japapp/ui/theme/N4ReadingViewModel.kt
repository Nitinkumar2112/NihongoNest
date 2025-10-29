package com.example.yourappname

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

// A simple state holder for this screen
data class N4ReadingUiState(
    val websites: List<LinkItem> = emptyList()
)

class N4ReadingViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(N4ReadingUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        _uiState.value = N4ReadingUiState(
            websites = getN4ReadingWebsites()
        )
    }
}