package com.example.carrentalapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carrentalapp.ui.screens.CreateAccountScreen
import com.example.carrentalapp.ui.screens.HomeScreen
import com.example.carrentalapp.ui.screens.LoginScreen
import com.example.carrentalapp.ui.theme.CarRentalAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		setContent {
			CarRentalAppTheme {
				
				
				val navController = rememberNavController()
				
				Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
					NavHost(
						modifier = Modifier.padding(innerPadding),
						
						navController = navController, startDestination = Screens.Login.route
					       ) {
						
						composable(route = Screens.Login.route) { LoginScreen(navController = navController) }
						composable(route = Screens.CreateAccount.route) { CreateAccountScreen(
							navController = navController) }
						composable(route = Screens.Home.route) { HomeScreen(navController = navController) }
					}
				}
			}
		}
	}
}


sealed class Screens(val route: String) {
	data object CreateAccount : Screens("createAccount")
	data object Login : Screens("login")
	data object Home : Screens("home")
}