package com.ibrahim.ny_populararticles.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ibrahim.ny_populararticles.network.NetworkState

abstract class BaseViewModel : ViewModel() {
    internal val _networkState = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState> = _networkState
}