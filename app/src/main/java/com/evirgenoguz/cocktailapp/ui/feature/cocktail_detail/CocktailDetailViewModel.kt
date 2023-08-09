package com.evirgenoguz.cocktailapp.ui.feature.cocktail_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.evirgenoguz.cocktailapp.core.BaseViewModel
import com.evirgenoguz.cocktailapp.data.NetworkResult
import com.evirgenoguz.cocktailapp.data.model.response.CocktailDetailList
import com.evirgenoguz.cocktailapp.data.model.ui.CocktailDetailUiModel
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CocktailDetailViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository
) : BaseViewModel() {

    private val _cocktailDetail = MutableLiveData<CocktailDetailUiModel>()
    val cocktailDetail: LiveData<CocktailDetailUiModel> = _cocktailDetail

    fun getCocktailDetailById(id: String) {
        viewModelScope.launch {
            cocktailRepository.getCocktailDetailByCategoryId(id).collect {result ->
                result.onSuccess {
                    _cocktailDetail.postValue(it)
                }
                result.onLoading {
                    if (it) showIndicator()
                    else hideIndicator()
                }
                result.onError {
                    showErrorDialog(it)
                }
            }
        }
    }

}