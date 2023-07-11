package com.evirgenoguz.cocktailapp.data.model.response

import com.google.gson.annotations.SerializedName

/**
 * @Author: Oguz Evirgen
 * @Date: 10.07.2023
 */

data class CocktailDetailList(
    @SerializedName("drinks")
    val cocktailDetailList: List<CocktailDetail>?
)
