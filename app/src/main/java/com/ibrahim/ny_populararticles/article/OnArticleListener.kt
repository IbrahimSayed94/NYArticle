package com.ibrahim.ny_populararticles.article

import com.ibrahim.ny_populararticles.model.Article

interface OnArticleListener {
    fun onClick(article : Article){}
}