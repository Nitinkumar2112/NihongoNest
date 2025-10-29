package com.example.yourappname

import android.widget.Toast // NEW IMPORT
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
import android.app.Activity


@Composable
fun FlashcardNavigator(onNavigateBack: () -> Unit) {
    var selectedSet by remember { mutableStateOf<FlashcardSet?>(null) }
    val allSets = remember { getAllFlashcardSets() }

    if (selectedSet == null) {
        FlashcardSetListScreen(
            sets = allSets,
            onSetSelected = { selectedSet = it },
            onNavigateBack = onNavigateBack
        )
    } else {
        FlashcardScreen(
            set = selectedSet!!,
            onNavigateBack = { selectedSet = null }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashcardSetListScreen(
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
            text = { Text("Watch a short ad to permanently unlock this lesson.") },
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
                title = { Text("Flashcard Lessons") },
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
                val isLocked = set.id.substringAfter('L').toInt() > 10 && !unlockedItems.contains(set.id)
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


// --- THIS COMPOSABLE IS NOW UPDATED ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashcardScreen(
    set: FlashcardSet,
    onNavigateBack: () -> Unit,
    viewModel: N4FlashcardViewModel = viewModel()
) {
    val context = LocalContext.current // Get context for the Toast

    // This effect runs once when the 'set' changes (i.e., when a new lesson is opened)
    LaunchedEffect(key1 = set) {
        viewModel.loadSet(set)
        // Show the Toast message
        Toast.makeText(context, "Click on the flashcard to see the meaning", Toast.LENGTH_SHORT).show()
    }

    val uiState by viewModel.uiState.collectAsState()
    val currentCard = uiState.currentSet?.cards?.getOrNull(uiState.currentIndex)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(uiState.currentSet?.title ?: "") },
                navigationIcon = { IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") } }
            )
        }
    ) { paddingValues ->
        if (currentCard != null) {
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                FlashcardContent(
                    card = currentCard,
                    isFlipped = uiState.isFlipped,
                    onFlip = viewModel::onFlipCard
                )
                Spacer(modifier = Modifier.height(32.dp))
                FlashcardControls(
                    onPrevious = viewModel::onPreviousCard,
                    onNext = viewModel::onNextCard,
                    onMark = viewModel::onMarkWord,
                    isPreviousEnabled = uiState.currentIndex > 0
                )
            }
        }
        if (uiState.showResultsDialog) {
            ResultsDialog(
                knownWords = uiState.knownWords,
                unknownWords = uiState.unknownWords,
                onDismiss = viewModel::dismissResultsDialog
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FlashcardContent(card: Flashcard, isFlipped: Boolean, onFlip: () -> Unit) {
    val rotation by animateFloatAsState(
        targetValue = if (isFlipped) 180f else 0f,
        animationSpec = tween(durationMillis = 500), label = ""
    )
    Card(
        onClick = onFlip,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.5f)
            .graphicsLayer { rotationY = rotation },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            if (rotation < 90f) {
                Text(card.japanese, style = MaterialTheme.typography.displayMedium, textAlign = TextAlign.Center)
            } else {
                Text(
                    card.meaning,
                    style = MaterialTheme.typography.headlineMedium,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .graphicsLayer { rotationY = 180f }
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun FlashcardControls(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    onMark: (Boolean) -> Unit,
    isPreviousEnabled: Boolean
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { onMark(false) },
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Icon(Icons.Default.Close, contentDescription = "Don't Know")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("Don't Know")
            }
            Button(
                onClick = { onMark(true) },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Icon(Icons.Default.Check, contentDescription = "I Know")
                Spacer(Modifier.size(ButtonDefaults.IconSpacing))
                Text("I Know")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier.fillMaxWidth(0.7f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = onPrevious, enabled = isPreviousEnabled) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Previous") }
            IconButton(onClick = onNext) { Icon(Icons.AutoMirrored.Filled.ArrowForward, "Next") }
        }
    }
}

@Composable
fun ResultsDialog(knownWords: Set<String>, unknownWords: Set<String>, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Card(modifier = Modifier.padding(16.dp).heightIn(max = 500.dp)) {
            Column(modifier = Modifier.padding(24.dp)) {
                Text("Session Complete!", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(16.dp))
                Text("Known Words: ${knownWords.size}", fontWeight = FontWeight.Bold)
                Text(knownWords.joinToString(", "))
                Spacer(modifier = Modifier.height(16.dp))
                Text("Unknown Words: ${unknownWords.size}", fontWeight = FontWeight.Bold)
                Text(unknownWords.joinToString(", "))
                Spacer(modifier = Modifier.height(24.dp))
                Button(onClick = onDismiss, modifier = Modifier.align(Alignment.End)) {
                    Text("OK")
                }
            }
        }
    }
}