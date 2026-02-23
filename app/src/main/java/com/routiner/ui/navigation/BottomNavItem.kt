package com.routiner.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val route: AppRoute,
    val icon: ImageVector,
    val contentDescription: String,
    val showBadge: Boolean = false
)
