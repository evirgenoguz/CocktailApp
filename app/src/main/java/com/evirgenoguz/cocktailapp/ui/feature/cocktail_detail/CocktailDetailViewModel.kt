package com.evirgenoguz.cocktailapp.ui.feature.cocktail_detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.cocktailapp.core.BaseViewModel
import com.evirgenoguz.cocktailapp.data.NetworkResult
import com.evirgenoguz.cocktailapp.data.ServerErrorModel
import com.evirgenoguz.cocktailapp.data.model.response.CocktailDetailList
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailDetailViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository
) : BaseViewModel() {

    private val _cocktailDetail = MutableLiveData<NetworkResult<CocktailDetailList>>()
    val cocktailDetail: LiveData<NetworkResult<CocktailDetailList>> = _cocktailDetail

    fun getCocktailDetailById(id: String) {
        viewModelScope.launch {
            cocktailRepository.getCocktailDetailByCategoryId(id)
                .onSuccess {cocktailListFlow ->
                    cocktailListFlow
                        .onStart {
                            Log.d("CocktailDetailViewModel", "onStart")
                            showIndicator()
                        }
                        .onCompletion {
                            Log.d("CocktailDetailViewModel", "onCompletion")
                            hideIndicator()
                        }
                        .collect { cocktailList ->
                            _cocktailDetail.postValue(NetworkResult.Success(cocktailList))
                        }
                }.onError {
                    _cocktailDetail.postValue(
                        NetworkResult.Error(
                            ServerErrorModel(it.message)
                        )
                    )
                    Log.d("CocktailDetailViewModel", it.message)
                }

        }
    }

}