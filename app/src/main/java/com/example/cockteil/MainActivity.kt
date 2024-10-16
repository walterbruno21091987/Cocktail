package com.example.cockteil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cockteil.ui.screen.MainMenu
import com.example.cockteil.ui.navigation.Routes
import com.example.cockteil.ui.screen.searchByName.SearchByName
import com.example.cockteil.ui.screen.searchByName.SearchByNameViewModel
import com.example.cockteil.ui.theme.CockteilTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CockteilTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    val navigationController = rememberNavController()
                    val searchByNameViewModel:SearchByNameViewModel = hiltViewModel()

                    NavHost(
                        navController = navigationController,
                        startDestination = Routes.MainMenu.route
                    ) {
                        composable(Routes.MainMenu.route) {
                            MainMenu(navController=navigationController)               }

                        composable(Routes.SearchByName.route) {
                            SearchByName(searchByNameViewModel = searchByNameViewModel)             }

                    }
                }
            }
        }
    }

}