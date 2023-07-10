package com.evirgenoguz.cocktailapp.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * @Author: Oguz Evirgen
 * @Date: 6.07.2023
 */

data class CocktailList(
    @SerializedName("drinks")
    val cocktailList: List<Cocktail>?
)
