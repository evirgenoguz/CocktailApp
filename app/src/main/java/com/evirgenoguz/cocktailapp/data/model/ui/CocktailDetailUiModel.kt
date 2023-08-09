package com.evirgenoguz.cocktailapp.data.model.ui


/**
 * @Author: Oguz Evirgen
 * @Date: 23.07.2023
 */

data class CocktailDetailUiModel(
    val idDrink: String,
    val strAlcoholic: String,
    val strCategory: String,
    val strDrink: String,
    val strDrinkThumb: String,
    val strGlass: String,
    val strImageSource: String?,
    val strIngredientList: MutableList<String>,
    val strInstructions: String,
    val strMeasureList: MutableList<String>,
    val strTags: String?,
    val strVideo: String?
)
