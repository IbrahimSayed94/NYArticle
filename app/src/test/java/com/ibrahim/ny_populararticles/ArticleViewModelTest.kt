package com.ibrahim.ny_populararticles

import com.ibrahim.ny_populararticles.model.ResultResponse
import com.ibrahim.ny_populararticles.network.ApiClient
import com.ibrahim.ny_populararticles.network.ApiService
import com.ibrahim.ny_populararticles.network.NetworkState
import com.ibrahim.ny_populararticles.repository.ArticleRepository
import com.ibrahim.ny_populararticles.viewmodel.ArticleViewModel
import com.nhaarman.mockitokotlin2.doReturn
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ArticleViewModelTest {

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @Mock
    private lateinit var apiService: ApiService

    @Mock
    private lateinit var testObserver: NetworkState

    private lateinit var apiClient: ApiClient
    private lateinit var articleRepository: ArticleRepository
    private lateinit var articleViewModel: ArticleViewModel


    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @Before
    fun setUpArticleViewModel() {
        MockitoAnnotations.initMocks(this)
        Dispatchers.setMain(mainThreadSurrogate)
        apiClient = ApiClient(apiService)
        articleRepository = ArticleRepository(apiClient)
        articleViewModel = ArticleViewModel(articleRepository)
    }

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun loadArticles(): Unit = runBlocking {
        launch(Dispatchers.Main) {  // Will be launched in the mainThreadSurrogate dispatcher
            val resultResponse = ResultResponse()

            doReturn(resultResponse).`when`(testObserver).data

            articleViewModel.getMostPopularArticles()
        }
    }



}