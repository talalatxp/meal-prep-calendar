package com.talaniacodes.mealprepcalendar.presentation.spending_list

import com.talaniacodes.mealprepcalendar.common.Constants.EMPTY_STRING
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel

data class SpendingListState(
    val spendings: List<SpendingModel> = emptyList(),
    val searchQuery: String = EMPTY_STRING
)