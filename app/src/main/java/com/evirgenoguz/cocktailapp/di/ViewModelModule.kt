package com.evirgenoguz.cocktailapp.di

import com.evirgenoguz.cocktailapp.data.NetworkManager
import com.evirgenoguz.cocktailapp.data.api.CocktailApi
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

/**
 * @Author: Oguz Evirgen
 * @Date: 2.07.2023
 */

@Module
@InstallIn(ViewModelComponent::class)
object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideCocktailRepository(
        apiService: CocktailApi,
        networkManager: NetworkManager
    ): CocktailRepository = CocktailRepository(apiService, networkManager)



}