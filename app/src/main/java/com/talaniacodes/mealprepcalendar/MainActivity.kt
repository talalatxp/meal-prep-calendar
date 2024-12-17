package com.talaniacodes.mealprepcalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.talaniacodes.mealprepcalendar.presentation.spending_detail.SpendingDetailScreen
import com.talaniacodes.mealprepcalendar.presentation.spending_list.SpendingListScreen
import com.talaniacodes.mealprepcalendar.presentation.ui.theme.MealPrepyAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPrepyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.SpendingListScreen.route
                    ) {
                        composable(
                            route = Screen.SpendingListScreen.route
                        ) {
                            SpendingListScreen(navController = navController)
                        }
                        composable(
                            route = Screen.SpendingDetailScreen.route + "/{spendingType}"
                        ) {
                            SpendingDetailScreen()
                        }
                    }
                }
            }
        }
    }
}