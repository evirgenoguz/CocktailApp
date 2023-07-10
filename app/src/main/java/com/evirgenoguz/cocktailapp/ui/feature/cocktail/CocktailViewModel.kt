package com.evirgenoguz.cocktailapp.ui.feature.cocktail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.cocktailapp.core.BaseViewModel
import com.evirgenoguz.cocktailapp.data.NetworkResult
import com.evirgenoguz.cocktailapp.data.model.response.Cocktail
import com.evirgenoguz.cocktailapp.data.model.response.CocktailList
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository
): BaseViewModel() {

    private val _cocktails = MutableLiveData<NetworkResult<CocktailList>>()
    val cocktails: LiveData<NetworkResult<CocktailList>> = _cocktails

    init {
        getCocktailsByCategory()
    }

    private fun getCocktailsByCategory(){
        viewModelScope.launch {
            _cocktails.postValue(NetworkResult.Loading)
            val result = cocktailRepository.getCocktailsByCategory()
            _cocktails.postValue(result)
        }
    }


}