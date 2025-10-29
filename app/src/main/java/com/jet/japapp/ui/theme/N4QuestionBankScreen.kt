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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.android.gms.ads.rewarded.RewardedAd

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun N4QuestionBankScreen(
    onNavigateBack: () -> Unit,
    onBankSelected: (QuestionBank) -> Unit
) {
    val banks = getAllN4QuestionBanks()
    val context = LocalContext.current

    var unlockedItems by remember { mutableStateOf(ScorePersistence.getUnlockedItems(context)) }
    var showAdDialog by remember { mutableStateOf<QuestionBank?>(null) }
    var rewardedAd by remember { mutableStateOf<RewardedAd?>(null) }

    LaunchedEffect(Unit) {
        loadRewardedAd(context) { ad -> rewardedAd = ad }
    }

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
                title = { Text("N4 Kanji Question Banks") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back") }
                }
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
                // A bank is locked if its number is > 4 AND its ID is not in our unlocked list
                val isLocked = bank.id.takeLast(1).toIntOrNull() ?: 0 > 4 && !unlockedItems.contains(bank.id)

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
