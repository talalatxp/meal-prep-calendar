package com.talaniacodes.mealprepcalendar.domain.use_case.get_spending

import com.talaniacodes.mealprepcalendar.common.Resource
import com.talaniacodes.mealprepcalendar.data.remote.dto.toModel
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import com.talaniacodes.mealprepcalendar.domain.repository.SpendingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSpendingUseCase @Inject constructor(
    private val repository: SpendingRepository
) {

    operator fun invoke(spendingType: String): Flow<Resource<SpendingModel>> = flow {
        try {
            emit(Resource.Loading<SpendingModel>())
            val spending = repository.getSpendingByType(spendingType).toModel()
            emit(Resource.Success<SpendingModel>(spending))
        } catch(e: HttpException) {
            emit(Resource.Error<SpendingModel>(e.localizedMessage ?: "Unexpected error"))
        } catch (e: IOException) { //cant talk to the api, no internet
            emit(Resource.Error<SpendingModel>("Couldn´t reach server"))
        }
    }
}