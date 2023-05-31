package com.example.moodapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
//import androidx.compose.material3.TextField
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavHostController
import com.example.moodapp.BottomNav
import com.example.moodapp.Screen
import com.example.moodapp.UserViewModel
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(navController: NavHostController, viewModel: UserViewModel) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        androidx.compose.material3.TextField (
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            singleLine = true
        )

        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true
        )
        Button(onClick = {
            viewModel.viewModelScope.launch {
                if (viewModel.login(username,password)) {
                    navController.navigate(BottomNav.MoodTracker.route)
                } else {
                    // Handle login error
                }
            }
        }) {
            Text("Log In")
        }

        }

        TextButton(onClick = { navController.navigate(Screen.RegisterScreen.route) }) {
            Text("Create an account")
        }
    }

