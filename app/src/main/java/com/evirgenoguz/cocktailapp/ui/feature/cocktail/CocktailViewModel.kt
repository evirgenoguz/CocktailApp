package com.evirgenoguz.cocktailapp.ui.feature.cocktail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.cocktailapp.core.BaseViewModel
import com.evirgenoguz.cocktailapp.data.NetworkResult
import com.evirgenoguz.cocktailapp.data.model.response.CocktailList
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import com.evirgenoguz.cocktailapp.utils.NetworkLiveData
import com.evirgenoguz.cocktailapp.utils.NetworkUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
    networkUtil: NetworkUtil
) : BaseViewModel() {

    private val _cocktails = MutableLiveData<NetworkResult<CocktailList>>()
    val cocktails: LiveData<NetworkResult<CocktailList>> = _cocktails

    private val _networkLiveData = NetworkLiveData(networkUtil)
    val networkLiveData: LiveData<Boolean> = _networkLiveData

    init {
        getCocktailsByCategory()
    }
    fun getCocktailsByCategory() {
        if (networkLiveData.value == true) {
            viewModelScope.launch {
                cocktailRepository.getCocktailsByCategory().onSuccess {
                    it.onStart {
                        Log.d("CocktailViewModel", "onStart")
                        showIndicator()
                    }.onCompletion {
                        Log.d("CocktailViewModel", "onCompletion")
                        hideIndicator()
                    }.collect { cocktailList ->
                        _cocktails.postValue(NetworkResult.Success(cocktailList))
                    }
                }.onError {
                    Log.d("CocktailViewModel", it.message)
                }
            }
        } else {
            Log.d("Deneme", "Aku yok")
        }
    }
}