package com.example.yourappname

import android.content.Context
import android.content.SharedPreferences

object ScorePersistence {
    private const val PREFS_NAME = "UserProgress"
    private const val KEY_SELECTED_LEVEL = "selected_level" // Key for saving the level

    private fun getPrefs(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    // --- NEW: Functions to save and get the selected level ---
    fun saveSelectedLevel(context: Context, level: String) {
        getPrefs(context).edit().putString(KEY_SELECTED_LEVEL, level).apply()
    }

    fun getSelectedLevel(context: Context): String? {
        return getPrefs(context).getString(KEY_SELECTED_LEVEL, null)
    }

    // --- Quiz Score Functions ---
    fun saveScore(context: Context, bankId: String, score: Int, total: Int) {
        getPrefs(context).edit().putString(bankId, "$score / $total").apply()
    }

    fun getScore(context: Context, bankId: String): String? {
        return getPrefs(context).getString(bankId, null)
    }

    // --- Generic Progress Functions (for Vocabulary, Kanji, etc.) ---
    fun saveProgress(context: Context, key: String, completedIds: Set<String>) {
        getPrefs(context).edit().putStringSet(key, completedIds).apply()
    }

    fun getProgress(context: Context, key: String): Set<String> {
        return getPrefs(context).getStringSet(key, emptySet()) ?: emptySet()
    }

    // --- Flashcard Progress Functions ---
    fun saveFlashcardProgress(context: Context, setId: String, knownWords: Set<String>, unknownWords: Set<String>) {
        val editor = getPrefs(context).edit()
        editor.putStringSet("${setId}_known", knownWords)
        editor.putStringSet("${setId}_unknown", unknownWords)
        editor.apply()
    }

    fun getFlashcardProgress(context: Context, setId: String): Pair<Set<String>, Set<String>> {
        val known = getPrefs(context).getStringSet("${setId}_known", emptySet()) ?: emptySet()
        val unknown = getPrefs(context).getStringSet("${setId}_unknown", emptySet()) ?: emptySet()
        return Pair(known, unknown)
    }

    // --- Functions for Unlocked Content ---
    fun getUnlockedItems(context: Context): Set<String> {
        return getPrefs(context).getStringSet("unlocked_items", emptySet()) ?: emptySet()
    }

    fun unlockItem(context: Context, itemId: String) {
        val unlocked = getUnlockedItems(context).toMutableSet()
        unlocked.add(itemId)
        getPrefs(context).edit().putStringSet("unlocked_items", unlocked).apply()
    }
}
