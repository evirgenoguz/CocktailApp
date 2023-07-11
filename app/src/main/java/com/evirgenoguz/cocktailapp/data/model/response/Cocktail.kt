package com.evirgenoguz.cocktailapp.data.model.response

import androidx.room.Entity
import com.evirgenoguz.cocktailapp.utils.Constants.COCKTAIL


data class Cocktail(
    val idDrink: String,
    val strDrink: String,
    val strDrinkThumb: String
)