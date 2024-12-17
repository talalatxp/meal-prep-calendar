package com.talaniacodes.mealprepcalendar.data.remote.dto

import com.talaniacodes.mealprepcalendar.domain.model.SpendingModel
import java.util.Date

data class SpendingDto(
    val id: String,
    val name: String,
    val type: String, //cambiar a enum
    val quantity: Double,
    val date: Date
)

fun SpendingDto.toModel() : SpendingModel {
    return SpendingModel(
        id = id,
        name = name,
        type = type,
        quantity = quantity,
        date = date
    )
}
