package com.example.yourappname// Make sure this package name matches yours

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.jet.japapp.R
import kotlin.math.abs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyScreen(
    level: String,
    scope: CoroutineScope,
    drawerState: DrawerState,
    onNavigateToN5QuestionBank: () -> Unit,
    onNavigateToN4QuestionBank: () -> Unit,
    onNavigateToDictionary: () -> Unit,
    onNavigateToN5Vocabulary: () -> Unit,
    onNavigateToN4Vocabulary: () -> Unit,
    onNavigateToN5Kanji: () -> Unit,
    onNavigateToN4Kanji: () -> Unit,
    onNavigateToN5Grammar: () -> Unit,
    onNavigateToN4Grammar: () -> Unit,
    onNavigateToN5Listening: () -> Unit,
    onNavigateToN4Listening: () -> Unit,
    onNavigateToN5Reading: () -> Unit,
    onNavigateToN4Reading: () -> Unit,
    onNavigateToN5Flashcards: () -> Unit,
    onNavigateToN4Flashcards: () -> Unit
) {
    val topBarContainerColor = if (isSystemInDarkTheme()) Color(0xFF283593) else Color(0xFFFFC1CC)
    val topBarContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("日本語-ネスト (JLPT - $level)") },
                navigationIcon = {
                    IconButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(Icons.Filled.Menu, "Open Navigation Menu")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarContainerColor,
                    titleContentColor = topBarContentColor,
                    navigationIconContentColor = topBarContentColor
                )
            )
        },
        bottomBar = { BannerAd() }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Spacer(Modifier.height(24.dp))
            PlaylistSection(
                level = level,
                onNavigateToN5Vocabulary = onNavigateToN5Vocabulary,
                onNavigateToN4Vocabulary = onNavigateToN4Vocabulary,
                onNavigateToN5Kanji = onNavigateToN5Kanji,
                onNavigateToN4Kanji = onNavigateToN4Kanji,
                onNavigateToN5Grammar = onNavigateToN5Grammar,
                onNavigateToN4Grammar = onNavigateToN4Grammar,
                onNavigateToN5Listening = onNavigateToN5Listening,
                onNavigateToN4Listening = onNavigateToN4Listening,
                onNavigateToN5Reading = onNavigateToN5Reading,
                onNavigateToN4Reading = onNavigateToN4Reading
            )
            Spacer(Modifier.height(32.dp))
            StudyMaterialSection(
                level = level,
                onNavigateToN5QuestionBank = onNavigateToN5QuestionBank,
                onNavigateToN4QuestionBank = onNavigateToN4QuestionBank,
                onNavigateToDictionary = onNavigateToDictionary,
                onNavigateToN5Flashcards = onNavigateToN5Flashcards,
                onNavigateToN4Flashcards = onNavigateToN4Flashcards
            )
            Spacer(Modifier.height(24.dp))
        }
    }
}

@Composable
fun BannerAd() {
    AndroidView(
        modifier = Modifier.fillMaxWidth(),
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                adUnitId = "ca-app-pub-7188716363710434/3033400941"
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlaylistSection(
    level: String,
    onNavigateToN5Vocabulary: () -> Unit,
    onNavigateToN4Vocabulary: () -> Unit,
    onNavigateToN5Kanji: () -> Unit,
    onNavigateToN4Kanji: () -> Unit,
    onNavigateToN5Grammar: () -> Unit,
    onNavigateToN4Grammar: () -> Unit,
    onNavigateToN5Listening: () -> Unit,
    onNavigateToN4Listening: () -> Unit,
    onNavigateToN5Reading: () -> Unit,
    onNavigateToN4Reading: () -> Unit
) {
    val playlists = if (level == "N5") getPlaylistsN5() else getPlaylistsN4()
    val pagerState = rememberPagerState { playlists.size }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val cardWidth = 160.dp
    val horizontalPadding = (screenWidth - cardWidth) / 2

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Best Playlist for JLPT $level",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.Start)
        )
        Spacer(Modifier.height(16.dp))
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 40.dp),
            pageSpacing = 16.dp
        ) { page ->
            val playlistItem = playlists[page]
            PlaylistCard(
                playlist = playlistItem,
                onClick = {
                    when {
                        playlistItem.title.contains("Vocabulary") && level == "N5" -> onNavigateToN5Vocabulary()
                        playlistItem.title.contains("Vocabulary") && level == "N4" -> onNavigateToN4Vocabulary()
                        playlistItem.title.contains("Kanji") && level == "N5" -> onNavigateToN5Kanji()
                        playlistItem.title.contains("Kanji") && level == "N4" -> onNavigateToN4Kanji()
                        playlistItem.title.contains("Grammar") && level == "N5" -> onNavigateToN5Grammar()
                        playlistItem.title.contains("Grammar") && level == "N4" -> onNavigateToN4Grammar()
                        playlistItem.title.contains("Listening") && level == "N5" -> onNavigateToN5Listening()
                        playlistItem.title.contains("Listening") && level == "N4" -> onNavigateToN4Listening()
                        playlistItem.title.contains("Reading") && level == "N5" -> onNavigateToN5Reading()
                        playlistItem.title.contains("Reading") && level == "N4" -> onNavigateToN4Reading()
                    }
                }
            )
        }
        Spacer(Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            repeat(playlists.size) { index ->
                val color = if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f)
                Box(Modifier.size(10.dp).clip(CircleShape).background(color))
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlaylistCard(playlist: Playlist, onClick: () -> Unit) {
    val borderColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val cardShape = RoundedCornerShape(20.dp)

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth() // Changed back to fill the width of the pager page
            .aspectRatio(1f)
            .border(width = 2.dp, color = borderColor, shape = cardShape),
        shape = cardShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = playlist.imageResId),
                contentDescription = playlist.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.8f)),
                            startY = 350f,
                            endY = 500f
                        )
                    )
            )
            Text(
                text = playlist.title,
                style = MaterialTheme.typography.titleMedium,
                color = Color.White,
                modifier = Modifier.align(Alignment.BottomStart).padding(16.dp)
            )
        }
    }
}

@Composable
fun StudyMaterialSection(
    level: String,
    onNavigateToN5QuestionBank: () -> Unit,
    onNavigateToN4QuestionBank: () -> Unit,
    onNavigateToDictionary: () -> Unit,
    onNavigateToN5Flashcards: () -> Unit,
    onNavigateToN4Flashcards: () -> Unit
) {
    val context = LocalContext.current
    val n5pyqUrl = "https://drive.google.com/drive/folders/1vouv1wGV8qqN5RTvO1Ber2nGr5Eao8Hb"
    val n5pyqIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(n5pyqUrl)) }

    val bookUrl = "https://linktr.ee/NihongoNest"
    val bookIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(bookUrl)) }

    val n4pyqUrl = "https://drive.google.com/drive/folders/138_Eo9kSgDt79NemrqKKv0BzPxLiqkGx"
    val n4pyqIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(n4pyqUrl)) }

    val studyMaterials = if (level == "N5") {
        listOf(
            StudyMaterialItem("Flashcards (暗記カード)", R.drawable.flashcard, onNavigateToN5Flashcards),
            StudyMaterialItem("N5 KANJI MCQ's", R.drawable.kanjitest, onNavigateToN5QuestionBank),
            StudyMaterialItem("JLPT N5 PYQ's", R.drawable.pyqs) { context.startActivity(n5pyqIntent) },
            StudyMaterialItem("JLPT N5 FREE BOOK PDF", R.drawable.freebook) { context.startActivity(bookIntent) },
            StudyMaterialItem("DICTIONARY (じしょ)", R.drawable.jisho, onNavigateToDictionary)
        )
    } else {
        // For N4, we build the list here to handle the link clicks correctly
        getStudyMaterialsN4(onNavigateToN4QuestionBank,onNavigateToDictionary,onNavigateToN4Flashcards).map { (title, imageResId) ->
            val onClickAction = when (title) {
                "N4 Flashcards" -> onNavigateToN4Flashcards
                "N4 KANJI MCQ's" -> onNavigateToN4QuestionBank
                // --- BUG FIX: Use the correct N4 intent here ---
                "JLPT N4 PYQ's" -> { { context.startActivity(n4pyqIntent) } }
                "JLPT N4 FREE BOOK PDF" -> { { context.startActivity(bookIntent) } }
                "DICTIONARY (じしょ)" -> onNavigateToDictionary
                else -> { {} }
            }
            StudyMaterialItem(title, imageResId, onClickAction)
        }
    }

    Column {
        Text(
            text = "Study Material 📚",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            studyMaterials.forEach { item ->
                StudyMaterialCard(
                    title = item.title,
                    imageResId = item.imageResId,
                    onClick = item.onClick
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StudyMaterialCard(
    title: String,
    @DrawableRes imageResId: Int,
    onClick: () -> Unit
) {
    val borderColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val cardShape = RoundedCornerShape(16.dp)

    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .border(width = 2.dp, color = borderColor, shape = cardShape),
        shape = cardShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = title,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = title,
                modifier = Modifier.size(48.dp).clip(CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudyScreenPreview() {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    StudyScreen(
        level = "N5",
        scope = scope,
        drawerState = drawerState,
        onNavigateToN5QuestionBank = {},
        onNavigateToN4QuestionBank = {},
        onNavigateToDictionary = {},
        onNavigateToN5Vocabulary = {},
        onNavigateToN4Vocabulary = {},
        onNavigateToN5Kanji = {},
        onNavigateToN4Kanji = {},
        onNavigateToN5Grammar = {},
        onNavigateToN4Grammar = {},
        onNavigateToN5Listening = {},
        onNavigateToN4Listening = {},
        onNavigateToN5Reading = {},
        onNavigateToN4Reading = {},
        onNavigateToN5Flashcards = {},
        onNavigateToN4Flashcards = {}
    )
}
