package com.talaniacodes.mealprepcalendar.data.mapper

import com.talaniacodes.mealprepcalendar.data.local.SpendingsEntity
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import kotlinx.coroutines.flow.Flow

interface SpendingMapper {
    fun toSpendingModelFlowList(
        spendingFlowList: Flow<List<SpendingsEntity>>
    ): Flow<List<SpendingModel>>
}