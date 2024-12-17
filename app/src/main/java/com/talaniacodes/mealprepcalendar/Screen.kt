package com.talaniacodes.mealprepcalendar

sealed class Screen(val route: String) {
    object SpendingListScreen : Screen("spending_list_screen")
    object SpendingDetailScreen : Screen("spending_detail_screen")
}