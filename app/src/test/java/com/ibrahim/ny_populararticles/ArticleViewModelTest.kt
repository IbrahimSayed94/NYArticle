package com.ibrahim.ny_populararticles

import com.ibrahim.ny_populararticles.model.ResultResponse
import com.ibrahim.ny_populararticles.network.ApiClient
import com.ibrahim.ny_populararticles.network.NetworkState
import com.ibrahim.ny_populararticles.repository.ArticleRepository
import com.ibrahim.ny_populararticles.viewmodel.ArticleViewModel
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ArticleViewModelTest {


    @Mock
    private lateinit var apiClient: ApiClient
    private lateinit var articleRepository: ArticleRepository
    private lateinit var articleViewModel: ArticleViewModel
    private lateinit var testObserver: NetworkState



    @Before
    fun setUpArticleViewModel() {
        MockitoAnnotations.initMocks(this)
        articleRepository = ArticleRepository(apiClient)
        articleViewModel = ArticleViewModel(articleRepository)
    }


    @Test
    fun loadArticles() {
         articleViewModel.getMostPopularArticles()
    }

}