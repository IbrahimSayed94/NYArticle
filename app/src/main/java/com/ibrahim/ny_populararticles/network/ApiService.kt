package com.ibrahim.ny_populararticles.network

import com.ibrahim.ny_populararticles.model.ResultResponse
import com.ibrahim.ny_populararticles.utils.Constant
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constant.MOST_POPULAR_ARTICLES)
    fun getMostPopularArticles(@Query("api-key") apiKey : String): Deferred<ResultResponse>
}