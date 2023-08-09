package com.evirgenoguz.cocktailapp.ext

import com.evirgenoguz.cocktailapp.data.model.response.CocktailDetail
import com.evirgenoguz.cocktailapp.data.model.response.CocktailDetailList
import com.evirgenoguz.cocktailapp.data.model.ui.CocktailDetailUiModel

/**
 * @Author: Oguz Evirgen
 * @Date: 23.07.2023
 */

fun CocktailDetailList.toUiModel(): CocktailDetailUiModel {
    val detailModel = (cocktailDetailList ?: emptyList()).first()
    return detailModel.toUiModel()
}

fun CocktailDetail.toUiModel(): CocktailDetailUiModel {

    val strIngredientList: MutableList<String> = mutableListOf()
    val strMeasureList: MutableList<String> = mutableListOf()

    if (this.strIngredient1 != null) strIngredientList.add(this.strIngredient1)
    if (this.strIngredient2 != null) strIngredientList.add(this.strIngredient2)
    if (this.strIngredient3 != null) strIngredientList.add(this.strIngredient3)
    if (this.strIngredient4 != null) strIngredientList.add(this.strIngredient4)
    if (this.strIngredient5 != null) strIngredientList.add(this.strIngredient5)
    if (this.strIngredient6 != null) strIngredientList.add(this.strIngredient6)
    if (this.strIngredient7 != null) strIngredientList.add(this.strIngredient7)
    if (this.strIngredient8 != null) strIngredientList.add(this.strIngredient8)
    if (this.strIngredient9 != null) strIngredientList.add(this.strIngredient9)
    if (this.strIngredient10 != null) strIngredientList.add(this.strIngredient10)
    if (this.strIngredient11 != null) strIngredientList.add(this.strIngredient11)
    if (this.strIngredient12 != null) strIngredientList.add(this.strIngredient12)
    if (this.strIngredient13 != null) strIngredientList.add(this.strIngredient13)
    if (this.strIngredient14 != null) strIngredientList.add(this.strIngredient14)
    if (this.strIngredient15 != null) strIngredientList.add(this.strIngredient15)

    if (this.strMeasure1 != null) strMeasureList.add(this.strMeasure1)
    if (this.strMeasure2 != null) strMeasureList.add(this.strMeasure2)
    if (this.strMeasure3 != null) strMeasureList.add(this.strMeasure3)
    if (this.strMeasure4 != null) strMeasureList.add(this.strMeasure4)
    if (this.strMeasure5 != null) strMeasureList.add(this.strMeasure5)
    if (this.strMeasure6 != null) strMeasureList.add(this.strMeasure6)
    if (this.strMeasure7 != null) strMeasureList.add(this.strMeasure7)
    if (this.strMeasure8 != null) strMeasureList.add(this.strMeasure8)
    if (this.strMeasure9 != null) strMeasureList.add(this.strMeasure9)
    if (this.strMeasure10 != null) strMeasureList.add(this.strMeasure10)
    if (this.strMeasure11 != null) strMeasureList.add(this.strMeasure11)
    if (this.strMeasure12 != null) strMeasureList.add(this.strMeasure12)
    if (this.strMeasure13 != null) strMeasureList.add(this.strMeasure13)
    if (this.strMeasure14 != null) strMeasureList.add(this.strMeasure14)
    if (this.strMeasure15 != null) strMeasureList.add(this.strMeasure15)



//    for (property in CocktailDetail :: class.members) {
//        if (property.name.contains("strIngredient")){
//            strIngredientList.add(this.)
//        }
//    }


    return CocktailDetailUiModel(
        this.idDrink,
        this.strAlcoholic,
        this.strCategory,
        this.strDrink,
        this.strDrinkThumb,
        this.strGlass,
        this.strImageSource,
        strIngredientList,
        this.strInstructions,
        strMeasureList,
        this.strTags,
        this.strVideo
    )
}
