package com.talaniacodes.mealprepcalendar.di

import com.talaniacodes.mealprepcalendar.common.Constants.BASE_URL
import com.talaniacodes.mealprepcalendar.data.remote.SpendingsApi
import com.talaniacodes.mealprepcalendar.data.repository.SpendingRepositoryImpl
import com.talaniacodes.mealprepcalendar.domain.repository.SpendingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSpendingsApi(): SpendingsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpendingsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSpendingRepository(api: SpendingsApi) : SpendingRepository{
        return SpendingRepositoryImpl(api)
    }
}