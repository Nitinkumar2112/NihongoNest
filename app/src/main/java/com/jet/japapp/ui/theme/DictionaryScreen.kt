package com.jet.japapp.ui.theme

import com.example.yourappname.JishoResult

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.yourappname.DictionaryUiState
import com.example.yourappname.DictionaryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DictionaryScreen(
    onNavigateBack: () -> Unit,
    viewModel: DictionaryViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var searchQuery by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dictionary (じしょ)") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            // Search Bar
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                label = { Text("Search any word, kanji, or romaji...") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
                keyboardActions = KeyboardActions(onSearch = { viewModel.searchWord(searchQuery) })
            )
            Spacer(modifier = Modifier.height(16.dp))

            // Results Area
            when (val state = uiState) {
                is DictionaryUiState.Idle -> {
                    Text("Enter a word to start searching.", modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                is DictionaryUiState.Loading -> {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                is DictionaryUiState.Error -> {
                    Text(state.message, modifier = Modifier.align(Alignment.CenterHorizontally))
                }
                is DictionaryUiState.Success -> {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                        items(state.results) { result ->
                            DictionaryResultCard(result = result)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun DictionaryResultCard(result: JishoResult) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Display Japanese word and reading
            result.japanese.firstOrNull()?.let { jp ->
                Text(
                    text = jp.word ?: result.slug,
                    style = MaterialTheme.typography.headlineSmall
                )
                jp.reading?.let { reading ->
                    Text(
                        text = reading,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Display English definitions
            result.senses.forEachIndexed { index, sense ->
                val definition = sense.englishDefinitions.joinToString(", ")
                Text("${index + 1}. (${sense.partsOfSpeech.joinToString(", ")}) $definition")
            }
        }
    }
}