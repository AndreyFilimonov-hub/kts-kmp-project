package com.filimonov.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filimonov.project.screens.loginscreen.LoginScreen
import com.filimonov.project.screens.welcomescreen.WelcomeScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen.route
    ) {
        composable(Screen.WelcomeScreen.route) {
            WelcomeScreen(
                navigateToLoginScreen = {
                    navController.navigate(Screen.LoginScreen.route)
                }
            )
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen()
        }
    }
}

sealed class Screen(val route: String) {

    data object WelcomeScreen : Screen("welcome")

    data object LoginScreen : Screen("login")
}