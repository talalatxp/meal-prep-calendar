package com.talaniacodes.mealprepcalendar.domain.model

import java.util.Date

data class SpendingModel(
    val id: String,
    val name: String,
    val type: String, //cambiar a enum
    val quantity: Double,
    val date: Date
)
