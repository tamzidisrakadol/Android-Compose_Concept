package com.example.androidandcomposeconcept.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidandcomposeconcept.presentation.screens.home.HomeScreen
import com.example.wealth.presentation.screens.WealthScreen

@Composable
fun AppNavGraph(modifier: Modifier = Modifier) {
    val navHostController = rememberNavController()
    Surface(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(navController = navHostController, startDestination = Screens.HomeScreen.route){
            composable(route = Screens.HomeScreen.route){
                HomeScreen(
                    primaryButtonClicked = {},
                    bannerClicked = {
                        navHostController.navigate(Screens.WealthScreen.route)
                    }
                )
            }
            composable(route = Screens.WealthScreen.route){
                WealthScreen(
                    primaryButtonClicked = {
                        navHostController.popBackStack()
                    }
                )
            }

        }
    }

}