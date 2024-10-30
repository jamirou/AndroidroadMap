package com.example.firebasepractice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firebasepractice.presentation.initial.InitialScreen
import com.example.firebasepractice.presentation.login.LoginScreen
import com.example.firebasepractice.presentation.signup.SignUpScreen

@Composable
fun NavigationWrapper(navHostController: NavHostController) {
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("login") },
                navigateToSignUp = { navHostController.navigate("signup") }
            )
        }
        composable("login") {
            LoginScreen()
        }
        composable("signup") {
            SignUpScreen()
        }
    }
}