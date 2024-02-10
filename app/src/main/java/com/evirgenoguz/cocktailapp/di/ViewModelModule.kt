package com.evirgenoguz.cocktailapp.di

import android.content.Context
import com.evirgenoguz.cocktailapp.data.NetworkManager
import com.evirgenoguz.cocktailapp.data.api.CocktailApi
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import com.evirgenoguz.cocktailapp.utils.NetworkUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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


    @Provides
    @ViewModelScoped
    fun provideNetworkUtil(
        @ApplicationContext application: Context,
    ) = NetworkUtil(application)
}