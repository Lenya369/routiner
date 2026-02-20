package com.routiner.ui.navigation

sealed interface AppRoute {
    val route: String

    data object Welcome : AppRoute {
        override val route: String = "welcome"
    }

    data object Login : AppRoute {
        override val route: String = "login"
    }

    data object Home : AppRoute {
        override val route: String = "home"
    }
}
