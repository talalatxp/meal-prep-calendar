package com.talaniacodes.mealprepcalendar.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class SpendingsEntity( //Esto setea el nombre de la base de datos=?
    val name: String,
    val type: String, //TODO cambiar a enum
    val quantity: Double,
    val date: Date,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)