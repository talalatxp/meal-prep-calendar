package com.talaniacodes.mealprepcalendar.domain.use_case.get_spendings

import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import com.talaniacodes.mealprepcalendar.domain.repository.SpendingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSpendingsUseCaseImpl(
    private val repository: SpendingRepository,
) : GetSpendingsUseCase {

    override operator fun invoke(query: String): Flow<List<SpendingModel>> {
        return repository.getSpendings(query)
    }
}