package com.talaniacodes.mealprepcalendar.data.repository

import com.talaniacodes.mealprepcalendar.data.remote.SpendingsApi
import com.talaniacodes.mealprepcalendar.data.remote.dto.SpendingDto
import com.talaniacodes.mealprepcalendar.domain.repository.SpendingRepository
import javax.inject.Inject

class SpendingRepositoryImpl @Inject constructor(
    private val api: SpendingsApi
) : SpendingRepository {

    override suspend fun getSpendings(): List<SpendingDto> {
       return api.getSpendings()
    }

    override suspend fun getSpendingByType(spendingType: String): SpendingDto {
        return api.getSpendingByType(spendingType)
    }
}