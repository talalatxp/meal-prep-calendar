package com.talaniacodes.mealprepcalendar.domain.use_case.get_spendings

import com.talaniacodes.mealprepcalendar.common.Resource
import com.talaniacodes.mealprepcalendar.data.remote.dto.toModel
import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import com.talaniacodes.mealprepcalendar.domain.repository.SpendingRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetSpendingsUseCase @Inject constructor(
    private val repository: SpendingRepository
) {

    operator fun invoke(): Flow<Resource<List<SpendingModel>>> = flow {
        try {
            emit(Resource.Loading<List<SpendingModel>>())
            val spendings = repository.getSpendings().map { it.toModel() }
            emit(Resource.Success<List<SpendingModel>>(spendings))
        } catch(e: HttpException) {
            emit(Resource.Error<List<SpendingModel>>(e.localizedMessage ?: "Unexpected error"))
        } catch (e: IOException) { //cant talk to the api, no internet
            emit(Resource.Error<List<SpendingModel>>("Couldn´t reach server"))
        }
    }
}