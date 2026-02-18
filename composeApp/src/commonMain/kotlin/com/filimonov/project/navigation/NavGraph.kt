package com.filimonov.project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filimonov.project.screens.loginscreen.LoginScreen
import com.filimonov.project.screens.welcomescreen.WelcomeScreen
import kotlinx.serialization.Serializable

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.WelcomeScreen
    ) {
        composable<Screen.WelcomeScreen> {
            WelcomeScreen(
                navigateToLoginScreen = {
                    navController.navigate(Screen.LoginScreen)
                }
            )
        }
        composable<Screen.LoginScreen> {
            LoginScreen()
        }
    }
}

sealed interface Screen {

    @Serializable
    data object WelcomeScreen : Screen

    @Serializable
    data object LoginScreen : Screen
}