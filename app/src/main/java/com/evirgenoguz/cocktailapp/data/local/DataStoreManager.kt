package com.evirgenoguz.cocktailapp.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.evirgenoguz.cocktailapp.utils.Constants.FAV_COCKTAILS
import kotlin.coroutines.coroutineContext

/**
 * @Author: Oguz Evirgen
 * @Date: 11.07.2023
 */

abstract class DataStoreManager(private val context: Context) {
    private val Context.dataStore:  DataStore<Preferences> by preferencesDataStore(name = FAV_COCKTAILS)
    private val dataStore = context.dataStore

    companion object {
        val DRINKID = stringPreferencesKey("DRINKID")
    }

    suspend fun addFavorite(idDrink: String){
        context.dataStore.edit {idDrinks ->
            idDrinks[DRINKID] = idDrink
        }
    }

    suspend fun getFavorites(){

    }
}