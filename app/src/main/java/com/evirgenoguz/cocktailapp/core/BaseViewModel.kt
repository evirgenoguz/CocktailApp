package com.evirgenoguz.cocktailapp.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evirgenoguz.cocktailapp.utils.NetworkLiveData
import com.evirgenoguz.cocktailapp.utils.NetworkUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @Author: OguzEvirgen
 * @Date: 2.07.2023
 */

open class BaseViewModel @Inject constructor() : ViewModel() {

    private val _indicator = MutableLiveData<Boolean>()
    val indicator: LiveData<Boolean> = _indicator

    @Inject
    lateinit var networkUtil: NetworkUtil

    private val _networkLiveData = NetworkLiveData(networkUtil)
    val networkLiveData: LiveData<Boolean> = _networkLiveData

    protected fun showIndicator() = _indicator.postValue(true)
    protected fun hideIndicator() = _indicator.postValue(false)

}