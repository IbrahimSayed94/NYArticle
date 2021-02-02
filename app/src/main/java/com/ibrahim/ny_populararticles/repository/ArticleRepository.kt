package com.ibrahim.ny_populararticles.repository

import android.util.Log
import com.ibrahim.ny_populararticles.network.ApiClient
import com.ibrahim.ny_populararticles.network.NetworkState
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val apiClient: ApiClient) {

    private val tag = "ArticleRepository"

    suspend fun getMostPopularArticles(onNetworkState: (NetworkState) -> Unit) {
        onNetworkState(NetworkState.LOADING)
        try {
            val response = apiClient.getMostPopularArticles()
            onNetworkState(NetworkState.getLoaded(response))
            Log.e(tag,"response : $response")
        } catch (t: Throwable) {
            onNetworkState(NetworkState.getErrorMessage(t))
            Log.e(tag,"fail : $t")
        }
    } // fun of getMostPopularArticles
}