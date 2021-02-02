package com.ibrahim.ny_populararticles.network

import com.ibrahim.ny_populararticles.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiClient @Inject constructor(private val apiService: ApiService)
{
    suspend fun getMostPopularArticles() = withContext(Dispatchers.IO)
    { apiService.getMostPopularArticles(apiKey = Constant.API_KEY).await() }
} // class of ApiClient