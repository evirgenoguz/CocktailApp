package com.evirgenoguz.cocktailapp.data.api

import com.evirgenoguz.cocktailapp.data.model.response.Cocktail
import com.evirgenoguz.cocktailapp.data.model.response.CocktailList
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: OguzEvirgen
 * @Date: 2.07.2023
 */

interface CocktailApi {

    @GET(GET_COCKTAILS_BY_CATEGORY)
    suspend fun getCocktailsByCategory(@Query("c") category: String): CocktailList


    private companion object {
        const val GET_COCKTAILS_BY_CATEGORY = "filter.php"
    }
}