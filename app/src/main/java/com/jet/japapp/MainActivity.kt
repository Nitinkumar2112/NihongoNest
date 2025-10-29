package com.jet.japapp // Or your package name

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.yourappname.* // Import everything from your main package
import com.google.android.gms.ads.MobileAds
import com.jet.japapp.ui.theme.DictionaryScreen
import com.jet.japapp.ui.theme.JapappTheme
import kotlinx.coroutines.launch

// --- UPDATED: Shared screens now know which level they came from ---
sealed class Screen {
    data object LevelSelector : Screen()
    data class Study(val level: String) : Screen()
    data class N5QuestionBankList(val fromLevel: String = "N5") : Screen()
    data class N4QuestionBankList(val fromLevel: String = "N4") : Screen()
    data class N5QuizSession(val bank: QuestionBank) : Screen()
    data class N4QuizSession(val bank: QuestionBank) : Screen()
    data class Dictionary(val fromLevel: String) : Screen() // Now holds the level
    data object N5Vocabulary : Screen()
    data object N4Vocabulary : Screen()
    data object N5Kanji : Screen()
    data object N4Kanji : Screen()
    data object N5Grammar : Screen()
    data object N4Grammar : Screen()
    data object N5Listening : Screen()
    data object N4Listening : Screen()
    data object N5Reading : Screen()
    data object N4Reading : Screen()
    data object N5Flashcards : Screen()
    data object N4Flashcards : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MobileAds.initialize(this) {}
        enableEdgeToEdge()
        setContent {
            JapappTheme {
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val context = LocalContext.current

                val savedLevel = remember { ScorePersistence.getSelectedLevel(context) }
                var currentScreen by remember {
                    mutableStateOf(
                        if (savedLevel != null) Screen.Study(savedLevel) else Screen.LevelSelector
                    )
                }

                BackHandler(enabled = currentScreen !is Screen.LevelSelector && currentScreen !is Screen.Study) {
                    when (val screen = currentScreen) { // Use 'val screen' to get access to properties
                        is Screen.N5QuizSession -> currentScreen = Screen.N5QuestionBankList()
                        is Screen.N4QuizSession -> currentScreen = Screen.N4QuestionBankList()
                        is Screen.Dictionary -> currentScreen = Screen.Study(screen.fromLevel)
                        is Screen.N5QuestionBankList -> currentScreen = Screen.Study(screen.fromLevel)
                        is Screen.N4QuestionBankList -> currentScreen = Screen.Study(screen.fromLevel)
                        is Screen.N5Vocabulary, is Screen.N5Kanji, is Screen.N5Grammar, is Screen.N5Listening, is Screen.N5Reading, is Screen.N5Flashcards -> {
                            currentScreen = Screen.Study("N5")
                        }
                        is Screen.N4Vocabulary, is Screen.N4Kanji, is Screen.N4Grammar, is Screen.N4Listening, is Screen.N4Reading, is Screen.N4Flashcards -> {
                            currentScreen = Screen.Study("N4")
                        }
                        else -> currentScreen = Screen.LevelSelector
                    }
                }

                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Column(
                                modifier = Modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text("App Menu", style = MaterialTheme.typography.titleLarge)
                                Spacer(modifier = Modifier.height(24.dp))

                                NavigationDrawerItem(
                                    icon = { Icon(Icons.Default.Info, contentDescription = "How to use this app") },
                                    label = { Text("How to use this app") },
                                    selected = false,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        val howToUseUrl = "https://youtu.be/RMrWaEf982o?si=jPxgTPgHlMSi15nf"
                                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(howToUseUrl))
                                        context.startActivity(intent)
                                    },
                                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                )
                                NavigationDrawerItem(
                                    icon = { Icon(Icons.Default.SwapHoriz, contentDescription = "Change Level") },
                                    label = { Text("Change Level") },
                                    selected = false,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        currentScreen = Screen.LevelSelector
                                    },
                                    modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                                )

                                Spacer(modifier = Modifier.height(24.dp))

                                val supportUrl = "https://coff.ee/nitinkhatana2112"
                                val supportIntent = remember { Intent(Intent.ACTION_VIEW, Uri.parse(supportUrl)) }

                                Button(
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        context.startActivity(supportIntent)
                                    },
                                    shape = RoundedCornerShape(16.dp),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color(0xFFFEDD01),
                                        contentColor = Color.Black
                                    )
                                ) {
                                    Image(
                                        painter = painterResource(id = R.drawable.buy),
                                        contentDescription = "Support Icon"
                                    )

                                }
                            }
                        }
                    }
                ) {
                    when (val screen = currentScreen) {
                        is Screen.LevelSelector -> {
                            LevelSelectorScreen(onLevelSelected = { level ->
                                ScorePersistence.saveSelectedLevel(context, level)
                                currentScreen = Screen.Study(level)
                            })
                        }
                        is Screen.Study -> {
                            StudyScreen(
                                level = screen.level,
                                scope = scope,
                                drawerState = drawerState,
                                onNavigateToN5QuestionBank = { currentScreen = Screen.N5QuestionBankList(screen.level) },
                                onNavigateToN4QuestionBank = { currentScreen = Screen.N4QuestionBankList(screen.level) },
                                onNavigateToDictionary = { currentScreen = Screen.Dictionary(screen.level) },
                                onNavigateToN5Vocabulary = { currentScreen = Screen.N5Vocabulary },
                                onNavigateToN4Vocabulary = { currentScreen = Screen.N4Vocabulary },
                                onNavigateToN5Kanji = { currentScreen = Screen.N5Kanji },
                                onNavigateToN4Kanji = { currentScreen = Screen.N4Kanji },
                                onNavigateToN5Grammar = { currentScreen = Screen.N5Grammar },
                                onNavigateToN4Grammar = { currentScreen = Screen.N4Grammar },
                                onNavigateToN5Listening = { currentScreen = Screen.N5Listening },
                                onNavigateToN4Listening = { currentScreen = Screen.N4Listening },
                                onNavigateToN5Reading = { currentScreen = Screen.N5Reading },
                                onNavigateToN4Reading = { currentScreen = Screen.N4Reading },
                                onNavigateToN5Flashcards = { currentScreen = Screen.N5Flashcards },
                                onNavigateToN4Flashcards = { currentScreen = Screen.N4Flashcards }
                            )
                        }
                        is Screen.N5QuestionBankList -> {
                            QuestionBankScreen(
                                onNavigateBack = { currentScreen = Screen.Study(screen.fromLevel) },
                                onBankSelected = { bank -> currentScreen = Screen.N5QuizSession(bank) }
                            )
                        }
                        is Screen.N4QuestionBankList -> {
                            N4QuestionBankScreen(
                                onNavigateBack = { currentScreen = Screen.Study(screen.fromLevel) },
                                onBankSelected = { bank -> currentScreen = Screen.N4QuizSession(bank) }
                            )
                        }
                        is Screen.N5QuizSession -> {
                            QuizSessionScreen(
                                bank = screen.bank,
                                onQuizFinished = { currentScreen = Screen.N5QuestionBankList() }
                            )
                        }
                        is Screen.N4QuizSession -> {
                            QuizSessionScreen(
                                bank = screen.bank,
                                onQuizFinished = { currentScreen = Screen.N4QuestionBankList() }
                            )
                        }
                        is Screen.Dictionary -> {
                            DictionaryScreen(onNavigateBack = { currentScreen = Screen.Study(screen.fromLevel) })
                        }
                        is Screen.N5Vocabulary -> {
                            VocabularyScreen(onNavigateBack = { currentScreen = Screen.Study("N5") })
                        }
                        is Screen.N4Vocabulary -> {
                            N4VocabularyScreen(onNavigateBack = { currentScreen = Screen.Study("N4") })
                        }
                        is Screen.N5Kanji -> {
                            KanjiScreen(onNavigateBack = { currentScreen = Screen.Study("N5") })
                        }
                        is Screen.N4Kanji -> {
                            N4KanjiScreen(onNavigateBack = { currentScreen = Screen.Study("N4") })
                        }
                        is Screen.N5Grammar -> {
                            GrammarScreen(onNavigateBack = { currentScreen = Screen.Study("N5") })
                        }
                        is Screen.N4Grammar -> {
                            N4GrammarScreen(onNavigateBack = { currentScreen = Screen.Study("N4") })
                        }
                        is Screen.N5Listening -> {
                            ListeningScreen(onNavigateBack = { currentScreen = Screen.Study("N5") })
                        }
                        is Screen.N4Listening -> {
                            N4ListeningScreen(onNavigateBack = { currentScreen = Screen.Study("N4") })
                        }
                        is Screen.N5Reading -> {
                            ReadingScreen(onNavigateBack = { currentScreen = Screen.Study("N5") })
                        }
                        is Screen.N4Reading -> {
                            N4ReadingScreen(onNavigateBack = { currentScreen = Screen.Study("N4") })
                        }
                        is Screen.N5Flashcards -> {
                            FlashcardNavigator(
                                onNavigateBack = { currentScreen = Screen.Study("N5") }
                            )
                        }
                        is Screen.N4Flashcards -> {
                            N4FlashcardNavigator(
                                onNavigateBack = { currentScreen = Screen.Study("N4") }
                            )
                        }
                    }
                }
            }
        }
    }
}
