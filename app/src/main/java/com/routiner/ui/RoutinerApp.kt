package com.routiner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.routiner.ui.navigation.AppRoute
import com.routiner.ui.screen.home.MainShellScreen
import com.routiner.ui.screen.login.OnbordingScreen
import com.routiner.ui.screen.splash.SplashScreen
import com.routiner.ui.theme.LocalSpacing
import com.routiner.ui.theme.RoutinerTheme

@Composable
fun RoutinerApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Splash.route
    ) {
        composable(AppRoute.Splash.route) {
            SplashScreen(onFinished = {
                navController.navigateToRoot(
                    route = AppRoute.Onbording,
                    popUpToRoute = AppRoute.Splash,
                    inclusive = true
                )
            })
        }

        composable(AppRoute.Onbording.route) {
            OnbordingScreen(onFinished = {
                navController.navigateToRoot(
                    route = AppRoute.Home,
                    popUpToRoute = AppRoute.Onbording,
                    inclusive = true
                )
            })
        }

        composable(AppRoute.Welcome.route) {
            ScreenTemplate(
                title = "Welcome",
                body = "Hello World",
                actionLabel = "Go to Login",
                onActionClick = { navController.navigateTo(AppRoute.Login) }
            )
        }
        composable(AppRoute.Login.route) {
            ScreenTemplate(
                title = "Login",
                body = "Login screen placeholder",
                actionLabel = "Open Home",
                onActionClick = {
                    navController.navigateToRoot(AppRoute.Home)
                }
            )
        }
        composable(AppRoute.Home.route) {
            MainShellScreen()
        }
    }
}

@Composable
private fun ScreenTemplate(
    title: String,
    body: String,
    actionLabel: String,
    onActionClick: () -> Unit
) {
    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(LocalSpacing.current.screen),
            verticalArrangement = Arrangement.spacedBy(
                LocalSpacing.current.large,
                Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = title, style = MaterialTheme.typography.headlineMedium)
            Text(text = body, style = MaterialTheme.typography.bodyLarge)
            Button(onClick = onActionClick) {
                Text(actionLabel)
            }
        }
    }
}

private fun NavHostController.navigateTo(route: AppRoute) {
    navigate(route.route)
}

private fun NavHostController.navigateToRoot(
    route: AppRoute, popUpToRoute: AppRoute = route,
    inclusive: Boolean = false
) {
    navigate(route.route) {
        popUpTo(popUpToRoute.route) {
            this.inclusive = inclusive
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Preview(showBackground = true)
@Composable
private fun RoutinerAppPreview() {
    RoutinerTheme {
        RoutinerApp()
    }
}
