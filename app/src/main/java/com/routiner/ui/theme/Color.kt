package com.routiner.ui.theme

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val PrimaryLight = Color(0xFF2E7D32)
val OnPrimaryLight = Color(0xFFFFFFFF)
val BackgroundLight = Color(0xFFF7F8F6)
val OnBackgroundLight = Color(0xFF1A1C19)
val SurfaceLight = Color(0xFFFFFFFF)
val OnSurfaceLight = Color(0xFF1A1C19)

val PrimaryDark = Color(0xFF81C784)
val OnPrimaryDark = Color(0xFF0F380F)
val BackgroundDark = Color(0xFF111410)
val OnBackgroundDark = Color(0xFFE3E3DD)
val SurfaceDark = Color(0xFF1A1D19)
val OnSurfaceDark = Color(0xFFE3E3DD)

val mainBlueGradient = Brush.linearGradient(
    colors = listOf(
        Color(0xFF6B73FF),
        Color(0xFF000DFF)
    ),
    start = Offset(0f, 0f),
    end = Offset(700f, 300f)
)

val blue40 = Color(0xFFAFB4FF)

val BottomBarActive = Color(0xFF2F3CFF)
val BottomBarInactive = Color(0xFFC9CBD3)
val BottomBarSurface = Color(0xFFFFFFFF)
val BottomBarBadge = Color(0xFFFF4D4F)
