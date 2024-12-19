package com.talaniacodes.mealprepcalendar.data.mapper

import com.talaniacodes.mealprepcalendar.data.local.SpendingsEntity
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SpendingMapperImpl :SpendingMapper{

    override fun toSpendingModelFlowList(
        spendingFlowList: Flow<List<SpendingsEntity>>
    ): Flow<List<SpendingModel>> {
        return spendingFlowList.map { spendingsList ->
            spendingsList.map { spending ->
                SpendingModel(
                    name = spending.name,
                    type = spending.type,
                    quantity = spending.quantity,
                    date = spending.date
                )
            }
        }
    }
}
