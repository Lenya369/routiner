package com.routiner.ui.screen.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.routiner.ui.navigation.AppRoute
import com.routiner.ui.navigation.BottomNavItem
import com.routiner.ui.theme.BottomBarActive
import com.routiner.ui.theme.BottomBarBadge
import com.routiner.ui.theme.BottomBarInactive
import com.routiner.ui.theme.BottomBarSurface

@Composable
fun MainShellScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route
    val currentDestination = backStackEntry?.destination
    val isTabRoute = bottomTabs.any { it.route.route == currentRoute }
    val isBackToHomeEnabled = isTabRoute && currentRoute != AppRoute.Home.route

    BackHandler(enabled = isBackToHomeEnabled) {
        navController.navigateToBottomTab(AppRoute.Home)
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            RoutinerBottomBar(
                currentDestinationRoute = currentRoute,
                onTabSelected = { route ->
                    val isSelected = currentDestination
                        ?.hierarchy
                        ?.any { destination -> destination.route == route.route } == true
                    if (isSelected) return@RoutinerBottomBar

                    navController.navigateToBottomTab(route)
                },
                onCreateClick = { navController.navigate(AppRoute.Create.route) }
            )
        }
    ) { innerPadding ->
        NavHost(
            modifier = Modifier.padding(innerPadding),
            navController = navController,
            startDestination = AppRoute.Home.route
        ) {
            composable(AppRoute.Home.route) {
                HomeFeedScreen()
            }
            composable(AppRoute.Progress.route) {
                BottomTabPlaceholder(
                    title = "Progress",
                    subtitle = "Track your streaks and weekly trends."
                )
            }
            composable(AppRoute.Notifications.route) {
                BottomTabPlaceholder(
                    title = "Notifications",
                    subtitle = "All reminders and updates appear here."
                )
            }
            composable(AppRoute.Profile.route) {
                BottomTabPlaceholder(
                    title = "Profile",
                    subtitle = "Your account and preferences."
                )
            }
            composable(AppRoute.Create.route) {
                BottomTabPlaceholder(
                    title = "Create Habit",
                    subtitle = "This is a separate route for the plus action."
                )
            }
        }
    }
}

@Composable
private fun HomeFeedScreen() {
    BottomTabPlaceholder(
        title = "Home",
        subtitle = "Main feed content goes here."
    )
}

@Composable
private fun BottomTabPlaceholder(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = subtitle,
            modifier = Modifier.padding(top = 8.dp),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun RoutinerBottomBar(
    currentDestinationRoute: String?,
    onTabSelected: (AppRoute) -> Unit,
    onCreateClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(horizontal = 16.dp)
            .padding(bottom = 12.dp)
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(72.dp),
            shape = RoundedCornerShape(36.dp),
            color = BottomBarSurface,
            shadowElevation = 8.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomBarTab(
                    icon = bottomTabs[0].icon,
                    contentDescription = bottomTabs[0].contentDescription,
                    isSelected = currentDestinationRoute == bottomTabs[0].route.route,
                    showBadge = bottomTabs[0].showBadge,
                    onClick = { onTabSelected(bottomTabs[0].route) }
                )
                BottomBarTab(
                    icon = bottomTabs[1].icon,
                    contentDescription = bottomTabs[1].contentDescription,
                    isSelected = currentDestinationRoute == bottomTabs[1].route.route,
                    showBadge = bottomTabs[1].showBadge,
                    onClick = { onTabSelected(bottomTabs[1].route) }
                )

                FloatingActionButton(
                    onClick = onCreateClick,
                    modifier = Modifier.size(56.dp),
                    containerColor = BottomBarActive,
                    shape = CircleShape,
                    elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp)
                ) {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Create",
                        tint = Color.White
                    )
                }

                BottomBarTab(
                    icon = bottomTabs[2].icon,
                    contentDescription = bottomTabs[2].contentDescription,
                    isSelected = currentDestinationRoute == bottomTabs[2].route.route,
                    showBadge = bottomTabs[2].showBadge,
                    onClick = { onTabSelected(bottomTabs[2].route) }
                )
                BottomBarTab(
                    icon = bottomTabs[3].icon,
                    contentDescription = bottomTabs[3].contentDescription,
                    isSelected = currentDestinationRoute == bottomTabs[3].route.route,
                    showBadge = bottomTabs[3].showBadge,
                    onClick = { onTabSelected(bottomTabs[3].route) }
                )
            }
        }
    }
}

@Composable
private fun BottomBarTab(
    icon: ImageVector,
    contentDescription: String,
    isSelected: Boolean,
    showBadge: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Box(
            modifier = Modifier.size(28.dp),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = if (isSelected) BottomBarActive else BottomBarInactive
            )
            if (showBadge) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(BottomBarBadge)
                )
            }
        }
    }
}

private val bottomTabs = listOf(
    BottomNavItem(
        route = AppRoute.Home,
        icon = Icons.Filled.Home,
        contentDescription = "Home"
    ),
    BottomNavItem(
        route = AppRoute.Progress,
        icon = Icons.Filled.Favorite,
        contentDescription = "Progress"
    ),
    BottomNavItem(
        route = AppRoute.Notifications,
        icon = Icons.Filled.Notifications,
        contentDescription = "Notifications",
        showBadge = true
    ),
    BottomNavItem(
        route = AppRoute.Profile,
        icon = Icons.Filled.Person,
        contentDescription = "Profile"
    )
)

private fun NavHostController.navigateToBottomTab(route: AppRoute) {
    navigate(route.route) {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}
