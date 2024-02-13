package com.evirgenoguz.cocktailapp.core

import androidx.lifecycle.LiveData
import com.evirgenoguz.cocktailapp.utils.NetworkLiveData
import com.evirgenoguz.cocktailapp.utils.NetworkUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

//@HiltViewModel
//open class NetworkStateViewModel @Inject constructor(
//): BaseViewModel() {
//
//    @Inject
//    lateinit var networkUtil: NetworkUtil
//
//    private val _networkLiveData = NetworkLiveData(networkUtil)
//    val networkLiveData: LiveData<Boolean> = _networkLiveData
//}