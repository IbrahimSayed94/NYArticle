package com.ibrahim.ny_populararticles.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ibrahim.ny_populararticles.base.BaseViewModel
import com.ibrahim.ny_populararticles.model.ResultResponse
import com.ibrahim.ny_populararticles.network.NetworkState
import com.ibrahim.ny_populararticles.repository.ArticleRepository
import kotlinx.coroutines.launch

class ArticleViewModel @ViewModelInject constructor(private val repository: ArticleRepository)  : BaseViewModel() {

    private var _articleObserver = MutableLiveData<ResultResponse>()
    val articleObserver : LiveData<ResultResponse> = _articleObserver


    fun getMostPopularArticles() {
        viewModelScope.launch {
            repository.getMostPopularArticles(
                onNetworkState = { networkState: NetworkState ->
                    _networkState.value = networkState
                    if(networkState.status == NetworkState.Status.SUCCESS)
                        _articleObserver.value = networkState.data as ResultResponse
                }
            )
        }
    } // fun of getMostPopularArticles
}