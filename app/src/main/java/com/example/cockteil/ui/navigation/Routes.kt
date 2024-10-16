package com.example.cockteil.ui.navigation

sealed class Routes (val route:String){
    data object MainMenu : Routes("MainMenu")
    data object SearchByName:Routes("SearchByName")
}