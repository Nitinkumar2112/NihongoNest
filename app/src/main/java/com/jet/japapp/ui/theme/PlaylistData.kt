package com.example.yourappname

import com.jet.japapp.R

// The Playlist data class has been removed from this file

private val allPlaylistsN5 = listOf(
    Playlist("Vocabulary", R.drawable.n5vocabimageresource),
    Playlist("Kanji", R.drawable.n5kanjiimageresources),
    Playlist("Grammar", R.drawable.n5grammarimageresource),
    Playlist("Listening", R.drawable.n5listeningimagersource),
    Playlist("Reading", R.drawable.n5readingimageresources)
)

fun getPlaylistsN5(): List<Playlist> {
    return allPlaylistsN5
}