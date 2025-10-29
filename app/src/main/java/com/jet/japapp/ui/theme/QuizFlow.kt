package com.example.yourappname

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.jet.japapp.R
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizSessionScreen(
    bank: QuestionBank,
    onQuizFinished: () -> Unit
) {
    val context = LocalContext.current
    var currentQuestionIndex by remember { mutableStateOf(0) }
    var userAnswers by remember { mutableStateOf(mapOf<Int, Int>()) }
    var timeLeft by remember { mutableStateOf(600) }
    var showTimeUpDialog by remember { mutableStateOf(false) }
    var showResultScreen by remember { mutableStateOf(false) }

    val mediaPlayer = remember {
        MediaPlayer.create(context, R.raw.naudio)
    }

    LaunchedEffect(Unit) {
        mediaPlayer.start()
    }

    DisposableEffect(Unit) {
        onDispose {
            mediaPlayer.release()
        }
    }

    LaunchedEffect(key1 = true) {
        while (timeLeft > 0 && !showResultScreen) {
            delay(1000L)
            timeLeft--
        }
        if (timeLeft == 0) {
            showTimeUpDialog = true
        }
    }

    if (showTimeUpDialog) {
        TimeUpDialog(onDismiss = onQuizFinished)
    }

    if (showResultScreen) {
        QuizResultScreen(
            bank = bank,
            userAnswers = userAnswers,
            onNavigateBack = onQuizFinished
        )
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(bank.title) },
                    actions = {
                        Text(
                            text = "Time: ${timeLeft / 60}:${String.format("%02d", timeLeft % 60)}",
                            modifier = Modifier.padding(end = 16.dp),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                )
            }
        ) { paddingValues ->
            QuizQuestionContent(
                modifier = Modifier.padding(paddingValues),
                question = bank.questions[currentQuestionIndex],
                questionNumber = currentQuestionIndex + 1,
                totalQuestions = bank.questions.size,
                selectedOption = userAnswers[currentQuestionIndex],
                onOptionSelected = { optionIndex ->
                    userAnswers = userAnswers + (currentQuestionIndex to optionIndex)
                },
                onNext = { if (currentQuestionIndex < bank.questions.size - 1) currentQuestionIndex++ },
                onPrevious = { if (currentQuestionIndex > 0) currentQuestionIndex-- },
                onFinish = {
                    val score = userAnswers.count { (index, answer) -> bank.questions[index].correctAnswerIndex == answer }
                    ScorePersistence.saveScore(context, bank.id, score, bank.questions.size)
                    showResultScreen = true
                }
            )
        }
    }
}

// --- THIS COMPOSABLE IS NOW UPDATED ---
@Composable
fun QuizQuestionContent(
    modifier: Modifier = Modifier,
    question: KanjiQuestion,
    questionNumber: Int,
    totalQuestions: Int,
    selectedOption: Int?,
    onOptionSelected: (Int) -> Unit,
    onNext: () -> Unit,
    onPrevious: () -> Unit,
    onFinish: () -> Unit
) {
    Column(modifier = modifier.fillMaxSize().padding(16.dp)) {
        Text("Question $questionNumber of $totalQuestions", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Text(question.questionText, style = MaterialTheme.typography.headlineSmall, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(24.dp))

        // --- NEW: Define the border color for the selected option ---
        val selectionBorderColor = if (isSystemInDarkTheme()) Color.White else Color.Black

        question.options.forEachIndexed { index, option ->
            val isSelected = selectedOption == index

            // Define a base modifier that will be used for all buttons
            val buttonModifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)

            Button(
                onClick = { onOptionSelected(index) },
                // Conditionally add the border modifier if this option is selected
                modifier = if (isSelected) {
                    buttonModifier.border(
                        width = 2.dp,
                        color = selectionBorderColor,
                        shape = ButtonDefaults.shape // Match the button's shape
                    )
                } else {
                    buttonModifier
                },
                // Keep the existing background color change
                colors = if (isSelected) {
                    ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                } else {
                    ButtonDefaults.buttonColors()
                }
            ) {
                Text(option.text)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Button(onClick = onPrevious, enabled = questionNumber > 1) { Text("Previous") }
            if (questionNumber == totalQuestions) {
                Button(onClick = onFinish, colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)) { Text("Finish Test") }
            } else {
                Button(onClick = onNext) { Text("Next") }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun QuizResultScreen(
    bank: QuestionBank,
    userAnswers: Map<Int, Int>,
    onNavigateBack: () -> Unit
) {
    var showReview by remember { mutableStateOf(false) }
    val score = userAnswers.count { (index, answer) -> bank.questions[index].correctAnswerIndex == answer }

    if (showReview) {
        AnswerReviewScreen(
            bank = bank,
            userAnswers = userAnswers,
            onNavigateBack = { showReview = false }
        )
    } else {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Result") },
                    navigationIcon = {
                        IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                    }
                )
            }
        ) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues).fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Quiz Finished!", style = MaterialTheme.typography.headlineLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Text("Your Score:", style = MaterialTheme.typography.headlineSmall)
                Text("$score / ${bank.questions.size}", style = MaterialTheme.typography.displayMedium, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(32.dp))
                Button(onClick = { showReview = true }) { Text("Review Answers") }
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = onNavigateBack) { Text("Back to Question Banks") }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnswerReviewScreen(
    bank: QuestionBank,
    userAnswers: Map<Int, Int>,
    onNavigateBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Answer Review") },
                navigationIcon = {
                    IconButton(onClick = onNavigateBack) { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back") }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues), contentPadding = PaddingValues(16.dp)) {
            itemsIndexed(bank.questions) { index, question ->
                Column(modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp)) {
                    Text("${index + 1}. ${question.questionText}", style = MaterialTheme.typography.titleLarge)
                    Spacer(modifier = Modifier.height(8.dp))
                    question.options.forEachIndexed { optionIndex, option ->
                        val userChoice = userAnswers[index]
                        val isCorrectAnswer = optionIndex == question.correctAnswerIndex
                        val wasUserChoice = optionIndex == userChoice

                        val color = when {
                            isCorrectAnswer -> Color(0xFF4CAF50) // Green
                            wasUserChoice && !isCorrectAnswer -> Color(0xFFF44336) // Red
                            else -> Color.Gray
                        }
                        Text("   • ${option.text}", color = color, fontSize = 18.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun TimeUpDialog(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Card(shape = RoundedCornerShape(16.dp)) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Oops!", style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Time's Up!", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onDismiss) {
                    Text("OK")
                }
            }
        }
    }
}