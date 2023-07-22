package com.evirgenoguz.cocktailapp.core

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.evirgenoguz.cocktailapp.data.ServerErrorModel

/**
 * @Author: OguzEvirgen
 * @Date: 2.07.2023
 */

abstract class BaseViewModel : ViewModel() {

    private val _indicator = MutableLiveData<Boolean>()
    val indicator: LiveData<Boolean> = _indicator

    private val _showErrorDialog: MutableLiveData<ServerErrorModel> = MutableLiveData()
    val showErrorDialog: LiveData<ServerErrorModel> = _showErrorDialog

    protected fun showIndicator() = _indicator.postValue(true)
    protected fun hideIndicator() = _indicator.postValue(false)
    protected fun showErrorDialog(errorModel: ServerErrorModel) = _showErrorDialog.postValue(errorModel)

}