package com.talaniacodes.mealprepcalendar.domain.repository

import com.talaniacodes.mealprepcalendar.data.remote.dto.SpendingDto

interface SpendingRepository {

    suspend fun getSpendings() : List<SpendingDto>

    suspend fun getSpendingByType(spendingType: String) : SpendingDto
}