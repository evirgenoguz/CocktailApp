package com.evirgenoguz.cocktailapp.data.repository

import com.evirgenoguz.cocktailapp.data.NetworkManager
import com.evirgenoguz.cocktailapp.data.NetworkResult
import com.evirgenoguz.cocktailapp.data.api.CocktailApi
import com.evirgenoguz.cocktailapp.data.model.response.Cocktail
import com.evirgenoguz.cocktailapp.data.model.response.CocktailDetailList
import com.evirgenoguz.cocktailapp.data.model.response.CocktailList

/**
 * @Author: OguzEvirgen
 * @Date: 2.07.2023
 */

class CocktailRepository(
    private val apiService: CocktailApi,
    private val networkManager: NetworkManager
) {

    suspend fun getCocktailsByCategory(): NetworkResult<CocktailList> {
        return networkManager.makeRequest {
            apiService.getCocktailsByCategory("Cocktail")
        }
    }

    suspend fun getCocktailDetailByCategoryId(id: String): NetworkResult<CocktailDetailList> {
        return networkManager.makeRequest {
            apiService.getCocktailDetailById(id)
        }
    }


}