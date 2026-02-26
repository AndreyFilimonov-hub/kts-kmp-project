package com.filimonov.vkclientkmp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.filimonov.vkclientkmp.presentation.screens.loginscreen.LoginScreen
import com.filimonov.vkclientkmp.presentation.screens.mainscreen.MainScreen
import com.filimonov.vkclientkmp.presentation.screens.onboardingscreen.OnboardingScreen
import kotlinx.serialization.Serializable

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.OnboardingScreen
    ) {
        composable<Screen.OnboardingScreen> {
            OnboardingScreen(
                onFinish = {
                    navController.navigate(Screen.LoginScreen) {
                        popUpTo(Screen.OnboardingScreen) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Screen.LoginScreen> {
            LoginScreen(
                navigateToMainScreen = {
                    navController.navigate(Screen.MainScreen) {
                        popUpTo(Screen.LoginScreen) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Screen.MainScreen> {
            MainScreen()
        }
    }
}

sealed interface Screen {

    @Serializable
    data object OnboardingScreen : Screen

    @Serializable
    data object LoginScreen : Screen

    @Serializable
    data object MainScreen: Screen
}