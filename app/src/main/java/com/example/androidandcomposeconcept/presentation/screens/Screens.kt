package com.example.androidandcomposeconcept.presentation.screens

sealed class Screens (val route:String){
    data object HomeScreen : Screens(route = "home_screen")
    class ProfileScreen : Screens(route = "profile_screen")
    class SettingsScreen : Screens(route = "settings_screen")

}