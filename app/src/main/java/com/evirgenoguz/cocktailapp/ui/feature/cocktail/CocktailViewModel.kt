package com.evirgenoguz.cocktailapp.ui.feature.cocktail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.cocktailapp.core.BaseViewModel
import com.evirgenoguz.cocktailapp.data.NetworkResult
import com.evirgenoguz.cocktailapp.data.model.response.Cocktail
import com.evirgenoguz.cocktailapp.data.model.response.CocktailList
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository,
) : BaseViewModel() {

    private val _cocktails = MutableLiveData<NetworkResult<CocktailList>>()
    val cocktails: LiveData<NetworkResult<CocktailList>> = _cocktails


    init {
        getCocktailsByCategory()
    }

    private fun getCocktailsByCategory() {
        viewModelScope.launch {
            cocktailRepository.getCocktailsByCategory().onSuccess {
                it.onStart {
                    Log.d("CocktailViewModel", "onStart")
                    showIndicator()
                }
                    .onCompletion {
                        Log.d("CocktailViewModel", "onCompletion")
                        hideIndicator()
                    }
                    .collect { cocktailList ->
                        _cocktails.postValue(NetworkResult.Success(cocktailList))
                    }
            }
                .onError {
                    Log.d("CocktailViewModel", it.message)
                }
//            _cocktails.postValue(NetworkResult.Loading)
//            val result = cocktailRepository.getCocktailsByCategory()
//            _cocktails.postValue(result)
        }
    }


}