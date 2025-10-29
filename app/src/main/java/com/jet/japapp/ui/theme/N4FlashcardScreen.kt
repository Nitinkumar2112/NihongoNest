package com.example.yourappname

import android.app.Activity
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.android.gms.ads.rewarded.RewardedAd

@Composable
fun N4FlashcardNavigator(onNavigateBack: () -> Unit) {
    var selectedSet by remember { mutableStateOf<FlashcardSet?>(null) }
    val allSets = remember { getAllN4FlashcardSets() }

    if (selectedSet == null) {
        N4FlashcardSetListScreen( // Use the N4 specific list screen
            sets = allSets,
            onSetSelected = { selectedSet = it },
            onNavigateBack = onNavigateBack
        )
    } else {
        N4FlashcardScreen(
            set = selectedSet!!,
            onNavigateBack = { selectedSet = null }
        )
    }
}

// --- THIS IS THE NEW, DEDICATED LIST SCREEN FOR N4 ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun N4FlashcardSetListScreen(
    sets: List<FlashcardSet>,
    onSetSelected: (FlashcardSet) -> Unit,
    onNavigateBack: () -> Unit
) {
    val context = LocalContext.current
    val topBarContainerColor = if (isSystemInDarkTheme()) Color(0xFF283593) else Color(0xFFFFC1CC)
    val topBarContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    var unlockedItems by remember { mutableStateOf(ScorePersistence.getUnlockedItems(context)) }
    var showAdDialog by remember { mutableStateOf<FlashcardSet?>(null) }
    var rewardedAd by remember { mutableStateOf<RewardedAd?>(null) }

    LaunchedEffect(Unit) {
        loadRewardedAd(context) { ad -> rewardedAd = ad }
    }

    if (showAdDialog != null) {
        AlertDialog(
            onDismissRequest = { showAdDialog = null },
            title = { Text("Unlock Lesson") },
            text = { Text("Watch a short ad to unlock this lesson permanently.") },
            confirmButton = {
                Button(
                    onClick = {
                        val ad = rewardedAd
                        val setToUnlock = showAdDialog
                        if (ad != null && setToUnlock != null) {
                            showRewardedAd(context as Activity, ad) {
                                ScorePersistence.unlockItem(context, setToUnlock.id)
                                unlockedItems = ScorePersistence.getUnlockedItems(context)
                                onSetSelected(setToUnlock)
                            }
                        }
                        showAdDialog = null
                    },
                    enabled = rewardedAd != null
                ) { Text("Watch Ad") }
            },
            dismissButton = {
                TextButton(onClick = { showAdDialog = null }) { Text("Cancel") }
            }
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("N4 Flashcard Lessons") },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") } },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarContainerColor,
                    titleContentColor = topBarContentColor,
                    navigationIconContentColor = topBarContentColor
                )
            )
        }
    ) { paddingValues ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(paddingValues),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(sets) { set ->
                // N4 lessons start at 26. We'll lock lessons 31 and higher.
                val isLocked = set.id.substringAfter('L').toInt() > 30 && !unlockedItems.contains(set.id)
                val (known, unknown) = ScorePersistence.getFlashcardProgress(context, set.id)
                val scoreText = if (!isLocked && (known.isNotEmpty() || unknown.isNotEmpty())) {
                    "${known.size} / ${set.cards.size}"
                } else null

                val borderColor = if (isSystemInDarkTheme()) Color.White else Color.Black
                val cardShape = RoundedCornerShape(12.dp)
                val cardModifier = if (isLocked) {
                    Modifier.aspectRatio(1f).border(2.dp, borderColor, cardShape).blur(8.dp)
                } else {
                    Modifier.aspectRatio(1f).border(2.dp, borderColor, cardShape)
                }

                Card(
                    onClick = {
                        if (isLocked) {
                            // --- THIS IS THE TOAST MESSAGE FOR N4 ---
                            Toast.makeText(context, "Watch an ad to unlock this lesson", Toast.LENGTH_SHORT).show()
                            showAdDialog = set
                        } else {
                            onSetSelected(set)
                        }
                    },
                    modifier = cardModifier,
                    shape = cardShape
                ) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        Column(
                            modifier = Modifier.padding(4.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(set.title, style = MaterialTheme.typography.titleMedium, textAlign = TextAlign.Center)
                            scoreText?.let {
                                Text(it, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.primary)
                            }
                        }
                        if (isLocked) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = "Locked",
                                tint = Color.White.copy(alpha = 0.7f),
                                modifier = Modifier.size(36.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun N4FlashcardScreen(
    set: FlashcardSet,
    onNavigateBack: () -> Unit,
    viewModel: N4FlashcardViewModel = viewModel()
) {
    // This screen is a wrapper that calls the existing FlashcardScreen UI
    // but injects the N4ViewModel.
    FlashcardScreen(
        set = set,
        onNavigateBack = onNavigateBack,
        viewModel = viewModel
    )
}