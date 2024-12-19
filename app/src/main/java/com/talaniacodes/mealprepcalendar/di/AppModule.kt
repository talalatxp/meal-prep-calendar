package com.talaniacodes.mealprepcalendar.di

import android.app.Application
import androidx.room.Room
import com.talaniacodes.mealprepcalendar.common.Constants.BASE_URL
import com.talaniacodes.mealprepcalendar.data.local.SpendingsDatabase
import com.talaniacodes.mealprepcalendar.data.local.SpendingsDatabase.Companion.DATABASE_NAME
import com.talaniacodes.mealprepcalendar.data.mapper.SpendingMapper
import com.talaniacodes.mealprepcalendar.data.remote.SpendingsApi
import com.talaniacodes.mealprepcalendar.data.repository.SpendingRepositoryImpl
import com.talaniacodes.mealprepcalendar.domain.repository.SpendingRepository
import com.talaniacodes.mealprepcalendar.domain.use_case.get_spendings.GetSpendingsUseCase
import com.talaniacodes.mealprepcalendar.domain.use_case.get_spendings.GetSpendingsUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSpendingsDataBase(app: Application): SpendingsDatabase{
        return Room.databaseBuilder(
            app,
            SpendingsDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideSpendingRepository(db: SpendingsDatabase, mapper: SpendingMapper) : SpendingRepository{
        return SpendingRepositoryImpl(db.dao, mapper)
    }

    @Provides
    @Singleton
    fun provideGetSpendingsUseCase(repository: SpendingRepository): GetSpendingsUseCase {
        return GetSpendingsUseCaseImpl(repository)
    }
}