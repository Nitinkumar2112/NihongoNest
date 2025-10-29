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
import com.jet.japapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReadingScreen(
    onNavigateBack: () -> Unit,
    viewModel: ReadingViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val topBarContainerColor = if (isSystemInDarkTheme()) Color(0xFF283593) else Color(0xFFFFC1CC)
    val topBarContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Reading Resources") },
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
                ExpandableVocabCard(
                    tracker = tracker,
                    onLessonToggled = viewModel::onLessonToggled
                )
            }

            item {
                ChannelLinksCard(
                    title = "N5 Reading Practice Websites",
                    channels = uiState.channels,
                    imageResId = R.drawable.webgo
                )
            }

            item {
                // This now calls the shared TipsCard function from CommonUI.kt
                TipsCard()
            }
        }
    }
}

// The duplicate TipsCard function has been removed from this file.