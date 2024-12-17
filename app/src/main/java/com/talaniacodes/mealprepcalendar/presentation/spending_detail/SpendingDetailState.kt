package com.talaniacodes.mealprepcalendar.presentation.spending_detail

import com.talaniacodes.mealprepcalendar.common.Constants
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel

data class SpendingDetailState(
    val isLoading: Boolean = false,
    val spending: SpendingModel? = null,
    val error: String = Constants.EMPTY_STRING
)