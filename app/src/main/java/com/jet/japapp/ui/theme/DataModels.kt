package com.example.yourappname

import androidx.annotation.DrawableRes
import com.jet.japapp.R

// This is now the central location for this data class
data class StudyMaterialItem(
    val title: String,
    @DrawableRes val imageResId: Int,
    val onClick: () -> Unit
)

// This is also a shared data class, so we'll put it here too
data class Playlist(
    val title: String,
    @DrawableRes val imageResId: Int
)