package com.evirgenoguz.cocktailapp.data.api

import com.evirgenoguz.cocktailapp.data.model.response.CocktailDetailList
import com.evirgenoguz.cocktailapp.data.model.response.CocktailList
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @Author: OguzEvirgen
 * @Date: 2.07.2023
 */

interface CocktailApi {

    @GET(ENDPOINT_GET_COCKTAILS_BY_CATEGORY)
    suspend fun getCocktailsByCategory(@Query(QUERY_CATEGORY) category: String): CocktailList


    @GET(ENDPOINT_GET_COCKTAIL_DETAIL_BY_ID)
    suspend fun getCocktailDetailById(@Query(QUERY_DETAIL_ID) id: String): CocktailDetailList


    private companion object {
        const val ENDPOINT_GET_COCKTAILS_BY_CATEGORY = "filter.php"
        const val QUERY_CATEGORY = "c"

        const val ENDPOINT_GET_COCKTAIL_DETAIL_BY_ID = "lookup.php"
        const val QUERY_DETAIL_ID = "i"
    }
}