package com.example.yourappname

import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jet.japapp.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelSelectorScreen(
    onLevelSelected: (String) -> Unit
) {
    // --- NEW: Define theme colors ---
    val topBarContainerColor = if (isSystemInDarkTheme()) Color(0xFF283593).copy(alpha = 0.9f) else Color(0xFFFFC1CC).copy(alpha = 0.9f)
    val topBarContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.japanese_background),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Scaffold(
            containerColor = Color.Transparent,
            topBar = {
                TopAppBar(
                    title = { Text("Welcome to NihongoNest") },
                    // --- UPDATED: Use theme colors ---
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = topBarContainerColor,
                        titleContentColor = topBarContentColor
                    )
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                    tonalElevation = 4.dp
                ) {
                    Text(
                        text = "Select Your Level",
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
                    )
                }

                Spacer(modifier = Modifier.height(32.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val levels = listOf("N5", "N4", "N3", "N2", "N1")
                    itemsIndexed(levels) { index, level ->
                        LevelCard(
                            level = level,
                            index = index,
                            isEnabled = level in listOf("N5", "N4"),
                            onLevelSelected = onLevelSelected
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LevelCard(
    level: String,
    index: Int,
    isEnabled: Boolean,
    onLevelSelected: (String) -> Unit
) {
    val context = LocalContext.current
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(100L * index)
        isVisible = true
    }

    val alpha by animateFloatAsState(
        targetValue = if (isVisible) 1f else 0f,
        animationSpec = tween(durationMillis = 500), label = ""
    )

    // --- UPDATED: Use theme colors for the card gradient ---
    val cardColors = if (isSystemInDarkTheme()) {
        listOf(Color(0xFF283593), Color(0xFF1A237E)) // Dark blue gradient
    } else {
        listOf(Color(0xFFFFC1CC), Color(0xFFF8BBD0)) // Light pink gradient
    }

    val textColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Card(
        modifier = Modifier
            .aspectRatio(1f)
            .alpha(alpha)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                if (isEnabled) {
                    onLevelSelected(level)
                } else {
                    Toast
                        .makeText(context, "JLPT $level will be available in a future update!", Toast.LENGTH_SHORT)
                        .show()
                }
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.verticalGradient(cardColors)),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "JLPT",
                    fontSize = 20.sp,
                    color = textColor.copy(alpha = 0.8f)
                )
                Text(
                    text = level,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold,
                    color = textColor
                )
            }
            if (!isEnabled) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.5f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Locked",
                        tint = Color.White,
                        modifier = Modifier.size(48.dp)
                    )
                }
            }
        }
    }
}
