package com.talaniacodes.mealprepcalendar.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [SpendingsEntity::class],
    version = 1
)
abstract class SpendingsDatabase : RoomDatabase() {

    abstract val dao: SpendingDao

    companion object{
        const val DATABASE_NAME = "spendings_db"
    }
}