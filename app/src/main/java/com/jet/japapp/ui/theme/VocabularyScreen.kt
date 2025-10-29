package com.example.yourappname

import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.BorderStroke
import com.jet.japapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VocabularyScreen(
    onNavigateBack: () -> Unit,
    viewModel: VocabularyViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    val topBarContainerColor = if (isSystemInDarkTheme()) {
        Color(0xFF283593)
    } else {
        Color(0xFFFFC1CC)
    }

    val topBarContentColor = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Vocabulary Resources") },
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
            horizontalAlignment = Alignment.CenterHorizontally // Center the new section
        ) {
            items(uiState.trackers) { tracker ->
                ExpandableVocabCard(
                    tracker = tracker,
                    onLessonToggled = viewModel::onLessonToggled
                )
            }

            // --- THIS IS THE NEW SECTION YOU REQUESTED ---
            item {
                Column(
                    modifier = Modifier.padding(top = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // 1. The Title
                    Text(
                        text = "Tips to Memorize Vocab! 💡",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    // 2. The Button
                    val context = LocalContext.current
                    val tipsUrl = "https://youtu.be/Lt_lRa6Ip6g?si=ZInY9wZArOp3bPcJ"
                    val tipsIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(tipsUrl)) }

                    val buttonBorderColor = if (isSystemInDarkTheme()) {
                        Color(0xFF283593)
                    } else {
                        Color(0xFFFFC1CC)
                    }

                    OutlinedButton(
                        onClick = { context.startActivity(tipsIntent) },
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(2.dp, buttonBorderColor) // Set the border color and width
                    ) {
                        Text("Watch Video Guide")
                    }
                }
            }
            // --- END OF NEW SECTION ---
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableVocabCard(
    tracker: ProgressTrackerState,
    onLessonToggled: (String, String, Boolean) -> Unit
) {
    var isExpanded by remember { mutableStateOf(false) }

    val borderColor = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }
    val cardShape = RoundedCornerShape(16.dp)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = borderColor,
                shape = cardShape
            ),
        shape = cardShape,
        onClick = { isExpanded = !isExpanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(tracker.title, style = MaterialTheme.typography.titleLarge)
                Icon(
                    imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                    contentDescription = "Expand"
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                LinearProgressIndicator(
                    progress = { tracker.progress },
                    modifier = Modifier
                        .weight(1f)
                        .height(12.dp)
                        .clip(RoundedCornerShape(6.dp)),
                    color = Color(0xFF4CAF50),
                    trackColor = MaterialTheme.colorScheme.surfaceVariant
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(tracker.progressText, style = MaterialTheme.typography.bodySmall)
            }

            AnimatedVisibility(visible = isExpanded) {
                Column(
                    modifier = Modifier.padding(top = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    tracker.lessons.forEach { lesson ->
                        LessonChecklistItem(
                            lesson = lesson,
                            isChecked = tracker.completedLessonIds.contains(lesson.id),
                            onCheckedChange = { isChecked ->
                                onLessonToggled(tracker.key, lesson.id, isChecked)
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun LessonChecklistItem(
    lesson: VocabLesson,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    val context = LocalContext.current
    val youtubeIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(lesson.youtubeUrl)) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp)),
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { onCheckedChange(!isChecked) }
                .padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(lesson.title, modifier = Modifier.weight(1f))

            IconButton(
                onClick = { context.startActivity(youtubeIntent) },
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ytlogo),
                    contentDescription = "Open YouTube Link"
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Checkbox(
                checked = isChecked,
                onCheckedChange = onCheckedChange
            )
        }
    }
}