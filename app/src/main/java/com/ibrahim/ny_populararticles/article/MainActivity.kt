package com.ibrahim.ny_populararticles.article

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ibrahim.ny_populararticles.R
import com.ibrahim.ny_populararticles.model.Article
import com.ibrahim.ny_populararticles.model.ResultResponse
import com.ibrahim.ny_populararticles.network.NetworkState
import com.ibrahim.ny_populararticles.utils.ProgressLoading
import com.ibrahim.ny_populararticles.viewmodel.ArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , OnArticleListener {


    @VisibleForTesting
    val articleVM by viewModels<ArticleViewModel>()

    private lateinit var adapter: ArticleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initList()
        initViewModel()
    } // fun of onCreate


    private fun initList()
    {
        adapter = ArticleAdapter(context = this,articleList = listOf(),onArticleListener = this)
        recyclerView_article.layoutManager = LinearLayoutManager(this)
        recyclerView_article.adapter = adapter
    } // fun of initList

    private fun initViewModel()
    {
        articleVM.getMostPopularArticles()

        articleVM.networkState.observe(this,networkStateObserver)
        articleVM.articleObserver.observe(this,articleObserver)
    } // fun of initViewModel

    private val networkStateObserver = Observer<NetworkState> { networkState ->
        when(networkState.status)
        {
            NetworkState.Status.RUNNING -> {
                ProgressLoading.show(this)
            } // LOADING
            NetworkState.Status.SUCCESS -> {
                ProgressLoading.dismiss()
            }// LOADED
            NetworkState.Status.FAILED -> {
                ProgressLoading.dismiss()
                this.showMessage(getString(R.string.something_wrong))
            } // FAILED
        }
    } // networkStateObserver


    private val articleObserver = Observer<ResultResponse>{ response ->
        response.results?.let { adapter.setList(it) }
    } // articleObserver


    override fun onClick(article: Article) {
        /* handle article click here */


    } // fun of onArticle click

} // class of MainActivity

private fun Context.showMessage(message : String)
{
    Toast.makeText(this,message, Toast.LENGTH_LONG).show()
} // fun of showMessage
