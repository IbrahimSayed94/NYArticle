package com.ibrahim.ny_populararticles.article

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ibrahim.ny_populararticles.R
import com.ibrahim.ny_populararticles.model.Article
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter(private val context: Context, private var articleList : List<Article>,private val onArticleListener: OnArticleListener)
    :  RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(v)     }

    override fun getItemCount(): Int {
        return  articleList.size
    }

    @SuppressLint("SetTextI18n", "CheckResult")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val article = articleList[position]


        holder.txtArticleTitle.text = article.title
        holder.txtArticleDescription.text = article.abstract
        holder.txtArticleDate.text = article.published_date

        Glide.with(context)
            .applyDefaultRequestOptions(RequestOptions().placeholder(R.color.grey))
            .load(article.media?.get(0)?.metadata?.get(0)?.url)
            .into(holder.imgArticle)


        holder.itemView.setOnClickListener { onArticleListener.onClick(article = article) }

    }

    inner class ViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        internal var txtArticleTitle: TextView = itemView.txt_article_title
        internal var txtArticleDescription: TextView = itemView.txt_article_description
        internal var txtArticleDate: TextView = itemView.txt_article_date
        internal var imgArticle: ImageView = itemView.img_article

    }

    fun setList(articleList: List<Article>)
    {
        this.articleList = articleList
        notifyDataSetChanged()
    } // fun of setList

} // class of Article Adapter