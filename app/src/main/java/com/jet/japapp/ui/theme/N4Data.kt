package com.example.yourappname

import com.jet.japapp.R

// Placeholder data for N4 Playlists
fun getPlaylistsN4(): List<Playlist> {
    return listOf(
        Playlist("N4 Vocabulary", R.drawable.n4vocabimg),
        Playlist("N4 Kanji", R.drawable.n4kanjiimg),
        Playlist("N4 Grammar", R.drawable.n4grammarimg),
        Playlist("N4 Listening", R.drawable.n4listeningimg),
        Playlist("N4 Reading", R.drawable.n4readingimg)
    )
}

// --- THIS IS THE CORRECTED FUNCTION ---
// It now has the correct name and parameters that StudyScreen is looking for.
fun getStudyMaterialsN4(
    onNavigateToQuestionBank: () -> Unit,
    onNavigateToDictionary: () -> Unit,
    onNavigateToFlashcards: () -> Unit
): List<StudyMaterialItem> {
    return listOf(
        StudyMaterialItem("N4 Flashcards", R.drawable.flashcard, onNavigateToFlashcards),
        StudyMaterialItem("N4 KANJI MCQ's", R.drawable.kanjitest, onNavigateToQuestionBank),
        StudyMaterialItem("JLPT N4 PYQ's", R.drawable.pyqs) { /* Add N4 PYQ link logic here */ },
        StudyMaterialItem("JLPT N4 FREE BOOK PDF", R.drawable.freebook) { /* Add N4 Book link logic here */ },
        StudyMaterialItem("DICTIONARY (じしょ)", R.drawable.jisho, onNavigateToDictionary)
    )
}
