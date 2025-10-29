package com.example.yourappname

import android.app.Activity
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.ads.rewarded.RewardedAd

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionBankScreen(
    onNavigateBack: () -> Unit,
    onBankSelected: (QuestionBank) -> Unit
) {
    val banks = getAllQuestionBanks()
    val context = LocalContext.current

    var unlockedItems by remember { mutableStateOf(ScorePersistence.getUnlockedItems(context)) }
    var showAdDialog by remember { mutableStateOf<QuestionBank?>(null) }
    var rewardedAd by remember { mutableStateOf<RewardedAd?>(null) }

    LaunchedEffect(Unit) {
        loadRewardedAd(context) { ad -> rewardedAd = ad }
    }

    // --- NEW: Define the top bar colors based on the theme ---
    val topBarContainerColor = if (isSystemInDarkTheme()) Color(0xFF283593) else Color(0xFFFFC1CC)
    val topBarContentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    if (showAdDialog != null) {
        AlertDialog(
            onDismissRequest = { showAdDialog = null },
            title = { Text("Unlock Quiz") },
            text = { Text("Watch a short ad to unlock this quiz permanently.") },
            confirmButton = {
                Button(
                    onClick = {
                        val ad = rewardedAd
                        val bankToUnlock = showAdDialog
                        if (ad != null && bankToUnlock != null) {
                            showRewardedAd(context as Activity, ad) {
                                ScorePersistence.unlockItem(context, bankToUnlock.id)
                                unlockedItems = ScorePersistence.getUnlockedItems(context)
                                onBankSelected(bankToUnlock)
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
                title = { Text("Kanji Question Banks") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                },
                // --- UPDATED: Use the new dynamic colors ---
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = topBarContainerColor,
                    titleContentColor = topBarContentColor,
                    navigationIconContentColor = topBarContentColor
                )
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(banks) { bank ->
                val isLocked = bank.id.substringAfter('_').toInt() > 5 && !unlockedItems.contains(bank.id)

                QuestionBankCard(
                    bank = bank,
                    isLocked = isLocked,
                    onClick = {
                        if (isLocked) {
                            showAdDialog = bank
                        } else {
                            onBankSelected(bank)
                        }
                    }
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuestionBankCard(
    bank: QuestionBank,
    isLocked: Boolean,
    onClick: () -> Unit
) {
    val context = LocalContext.current
    val savedScore = ScorePersistence.getScore(context, bank.id)

    // --- NEW: Define the border color based on the theme ---
    val borderColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val cardShape = RoundedCornerShape(16.dp)

    val cardModifier = if (isLocked) {
        Modifier
            .aspectRatio(1f)
            .border(2.dp, borderColor, cardShape)
            .blur(8.dp)
    } else {
        Modifier
            .aspectRatio(1f)
            .border(2.dp, borderColor, cardShape)
    }

    Card(
        onClick = onClick,
        modifier = cardModifier,
        shape = cardShape,
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = bank.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                if (!isLocked && savedScore != null) {
                    Text(
                        text = savedScore,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(top = 8.dp)
                    )
                }
            }
            if (isLocked) {
                Icon(
                    imageVector = Icons.Default.Lock,
                    contentDescription = "Locked",
                    tint = Color.White.copy(alpha = 0.7f),
                    modifier = Modifier.size(48.dp)
                )
            }
        }
    }
}