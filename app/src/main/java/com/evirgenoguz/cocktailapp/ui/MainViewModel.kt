package com.evirgenoguz.cocktailapp.ui

import com.evirgenoguz.cocktailapp.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: Oguz Evirgen
 * @Date: 2.07.2023
 */

@HiltViewModel
class MainViewModel @Inject constructor() : BaseViewModel() {

    private companion object {
        val TAG: String = MainViewModel::class.java.simpleName
    }

}