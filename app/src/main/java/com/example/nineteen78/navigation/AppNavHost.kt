package com.example.nineteen78.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.nineteen78.ui.theme.screens.SplashScreen
import com.example.nineteen78.ui.theme.screens.client.AddClientScreen
import com.example.nineteen78.ui.theme.screens.client.ViewClients
import com.example.nineteen78.ui.theme.screens.client.updateClientScreen
import com.example.nineteen78.ui.theme.screens.dashboard.Dashboard
import com.example.nineteen78.ui.theme.screens.login.loginScreen
import com.example.nineteen78.ui.theme.screens.signup.signupScreen

@Composable
fun AppNavHost(navController: NavHostController = rememberNavController(),
               startDestination:String = ROUTE_SPLASH){
    NavHost(navController = navController,
        startDestination = startDestination ){
        composable(ROUTE_SPLASH) { SplashScreen {
            navController.navigate(ROUTE_REGISTER){
                popUpTo(ROUTE_SPLASH){inclusive = true}
            }
        }  }
        composable(ROUTE_REGISTER){ signupScreen(navController) }
        composable(ROUTE_LOGIN){ loginScreen(navController)}
        composable(ROUTE_HOME) { Dashboard(navController) }
        composable(ROUTE_ADD_CLIENT) { AddClientScreen(navController)}
        composable(ROUTE_VIEW_CLIENT) { ViewClients(navController)}
        composable("$ROUTE_UPDATE_CLIENT/{id}") {
                passedData -> updateClientScreen(
            navController,passedData.arguments?.getString("id")!!)
        }
    }
}