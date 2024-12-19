package com.talaniacodes.mealprepcalendar.data.repository

import com.talaniacodes.mealprepcalendar.data.local.SpendingDao
import com.talaniacodes.mealprepcalendar.data.mapper.SpendingMapper
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import com.talaniacodes.mealprepcalendar.domain.repository.SpendingRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SpendingRepositoryImpl @Inject constructor(
    private val dao: SpendingDao,
    private val mapper: SpendingMapper
) : SpendingRepository {

    override fun getSpendings(
        query: String
    ): Flow<List<SpendingModel>> {
        val localSpendingsList = dao.searchSpendingList(query)
        return mapper.toSpendingModelFlowList(localSpendingsList)
    }
}