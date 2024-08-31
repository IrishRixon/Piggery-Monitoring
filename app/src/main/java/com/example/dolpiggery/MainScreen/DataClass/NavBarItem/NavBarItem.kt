package com.example.dolpiggery.MainScreen.DataClass.NavBarItem

import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val title: String,
    val route: Any,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val hasNews: Boolean,
)
