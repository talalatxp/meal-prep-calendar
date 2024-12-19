package com.talaniacodes.mealprepcalendar.domain.repository

import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import kotlinx.coroutines.flow.Flow

interface SpendingRepository {

    fun getSpendings(query: String) : Flow<List<SpendingModel>>
}