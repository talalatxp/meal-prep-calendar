package com.talaniacodes.mealprepcalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.talaniacodes.mealprepcalendar.ui.theme.MealPrepyAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealPrepyAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    
                }
            }
        }
    }
}