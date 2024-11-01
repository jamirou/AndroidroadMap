package com.example.firebasepractice

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.firebasepractice.presentation.home.HomeScreen
import com.example.firebasepractice.presentation.initial.InitialScreen
import com.example.firebasepractice.presentation.login.LoginScreen
import com.example.firebasepractice.presentation.signup.SignUpScreen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth, db: FirebaseFirestore) {
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("login") },
                navigateToSignUp = { navHostController.navigate("signup") }
            )
        }
        composable("login") {
            LoginScreen(auth) { navHostController.navigate("home") }
        }
        composable("signup") {
            SignUpScreen(auth)
        }
        composable("home") {
            HomeScreen(db)
        }
    }
}