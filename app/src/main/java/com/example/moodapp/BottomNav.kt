package com.example.moodapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNav(
    val route: String,
    val title: String,
    val icon: ImageVector
){
    object MoodTracker: BottomNav(
        route= "tracker",
        title= "Tracker",
        icon = Icons.Default.Home
    )
    object Notes: BottomNav(
        route= "notes",
        title= "Notes",
        icon = Icons.Default.AccountBox
    )
    object Tips: BottomNav(
        route= "tips",
        title= "Tips",
        icon = Icons.Default.Favorite
    )



}
