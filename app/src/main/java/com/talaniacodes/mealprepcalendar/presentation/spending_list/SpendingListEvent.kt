package com.talaniacodes.mealprepcalendar.presentation.spending_list

sealed class SpendingListEvent {
    data class OnSearchQueryChange(val query: String): SpendingListEvent()
}