package com.evirgenoguz.cocktailapp.ui.feature.favorite

import com.evirgenoguz.cocktailapp.core.BaseViewModel
import com.evirgenoguz.cocktailapp.data.repository.CocktailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val cocktailRepository: CocktailRepository
): BaseViewModel() {
    // TODO: Implement the ViewModel
}