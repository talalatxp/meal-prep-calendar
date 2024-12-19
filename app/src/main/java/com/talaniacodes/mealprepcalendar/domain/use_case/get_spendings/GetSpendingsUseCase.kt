package com.talaniacodes.mealprepcalendar.domain.use_case.get_spendings

import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import kotlinx.coroutines.flow.Flow

interface GetSpendingsUseCase {
    operator fun invoke(query: String): Flow<List<SpendingModel>>
}