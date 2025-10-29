package com.example.yourappname

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GrammarScreen(
    onNavigateBack: () -> Unit,
    viewModel: GrammarViewModel = viewModel() // Use the new GrammarViewModel
) {
    val uiState by viewModel.uiState.collectAsState()

    val topBarContainerColor = if (isSystemInDarkTheme()) Color(0xFF283593) else Color(0xFFFFC1CC)
    val topBarContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Grammar Resources") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarContainerColor,
                    titleContentColor = topBarContentColor,
                    navigationIconContentColor = topBarContentColor
                )
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(uiState.trackers) { tracker ->
                ExpandableVocabCard( // We reuse this composable from the Vocabulary screen
                    tracker = tracker,
                    onLessonToggled = viewModel::onLessonToggled
                )
            }

            item {
                Column(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Tips to Master Grammar! ✨",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    val context = LocalContext.current
                    val tipsUrl = "https://youtu.be/SfnG2M5uYVk?si=r0UCs5Dkvy3uzG9L"
                    val tipsIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(tipsUrl)) }
                    val buttonBorderColor = if (isSystemInDarkTheme()) Color(0xFF283593) else Color(0xFFFFC1CC)

                    OutlinedButton(
                        onClick = { context.startActivity(tipsIntent) },
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(2.dp, buttonBorderColor)
                    ) {
                        Text("Watch Video Guide")
                    }
                }
            }
        }
    }
}