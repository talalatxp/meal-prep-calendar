package com.talaniacodes.mealprepcalendar.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface SpendingDao {

    @Upsert //como insert pero si ya existe ese spending lo actualiza
    suspend fun insertSpending(spending: SpendingsEntity)

    @Delete
    suspend fun deleteSpending(spending: SpendingsEntity)

    @Query("SELECT * FROM spendingsentity ORDER BY name ASC") //TODO dejar esto en una solo funcion que en funcion de que le pase ordenar una cosa u otra y el orden
    suspend fun getSpendingOrderedByName(): Flow<List<SpendingsEntity>> //con flow cada vez que se modifica un spending se ordena la lista con el nuevo

    @Query(
        """
            SELECT *
            FROM spendingsentity
            WHERE LOWER(name) LIKE '%' || LOWER(:query) || '%'
        """
    )
    fun searchSpendingList(query: String): Flow<List<SpendingsEntity>>

    @Query("DELETE FROM spendingsentity")
    suspend fun clearSpendingsList()
}