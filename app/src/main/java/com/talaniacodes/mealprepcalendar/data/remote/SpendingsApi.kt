package com.talaniacodes.mealprepcalendar.data.remote

import com.talaniacodes.mealprepcalendar.data.remote.dto.SpendingDto
import retrofit2.http.GET
import retrofit2.http.Path

interface SpendingsApi {

    @GET("/v1/spendings")
    suspend fun getSpendings(): List<SpendingDto>

    @GET("/v1/spendings/{spendingType}")
    suspend fun getSpendingByType(
        @Path("spendingType") spendingType: String
    ): SpendingDto
}