package com.evirgenoguz.cocktailapp.data.repository

import com.evirgenoguz.cocktailapp.data.NetworkManager
import com.evirgenoguz.cocktailapp.data.NetworkResult
import com.evirgenoguz.cocktailapp.data.api.CocktailApi
import com.evirgenoguz.cocktailapp.data.model.response.CocktailDetailList
import com.evirgenoguz.cocktailapp.data.model.response.CocktailList
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * @Author: OguzEvirgen
 * @Date: 2.07.2023
 */

class CocktailRepository(
    private val apiService: CocktailApi,
    private val networkManager: NetworkManager
) {

    suspend fun getCocktailsByCategory(): Flow<NetworkResult<CocktailList>> = flow {
        emit(NetworkResult.Loading(true))
        val response = networkManager.makeRequest {
            apiService.getCocktailsByCategory("Cocktail")
        }
        delay(750)
        emit(response)
        emit(NetworkResult.Loading(false))

    }

    suspend fun getCocktailDetailByCategoryId(id: String): Flow<NetworkResult<CocktailDetailList>> = flow {
        emit(NetworkResult.Loading(true))
        val response = networkManager.makeRequest {
            apiService.getCocktailDetailById(id)
        }
        delay(750)
        emit(response)
        emit(NetworkResult.Loading(false))
    }


}