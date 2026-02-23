package com.routiner.ui.navigation

sealed interface AppRoute {
    val route: String

    data object Splash : AppRoute {
        override val route: String = "splash"
    }

    data object Onbording : AppRoute {
        override val route: String = "onbording"
    }

    data object Welcome : AppRoute {
        override val route: String = "welcome"
    }

    data object Login : AppRoute {
        override val route: String = "login"
    }

    data object Home : AppRoute {
        override val route: String = "home"
    }

    data object Progress : AppRoute {
        override val route: String = "progress"
    }

    data object Create : AppRoute {
        override val route: String = "create"
    }

    data object Notifications : AppRoute {
        override val route: String = "notifications"
    }

    data object Profile : AppRoute {
        override val route: String = "profile"
    }
}
