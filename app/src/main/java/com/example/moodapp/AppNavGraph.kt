package com.example.moodapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.moodapp.screens.*

@Composable
fun AppNavGraph(navController: NavHostController, userViewModel: UserViewModel) {
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
            SplashScreen(navController)
        }
        composable("welcome_screen") {
            WelcomeScreen(navController)
        }
        composable("login_screen") {
            LoginScreen(navController, userViewModel)
        }
        composable("register_screen") {
            RegisterScreen(navController, userViewModel)
        }
        composable(route = BottomNav.MoodTracker.route) {
            CalenderScreen()
        }
        composable(route = BottomNav.Tips.route) {
            Tips()
        }
        composable(route = BottomNav.Notes.route) {
            Notes()
        }
    }
}


