    package com.codepath.articlesearch

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

const val ARTICLE_EXTRA = "ARTICLE_EXTRA"
private const val TAG = "ArticleAdapter"

class ArticleAdapter(private val context: Context, private val articles: List<Article>) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        return ViewHolder(view)
    }

    fun bind(article: Article, holder: ViewHolder) {
        holder.titleTextView.text = article.headline?.main
        holder.abstractTextView.text = article.abstract

        Glide.with(context)
            .load(article.mediaImageUrl)
            .into(holder.mediaImageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        bind(article,holder)


    }
    override fun getItemCount() = articles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        internal val mediaImageView = itemView.findViewById<ImageView>(R.id.mediaImage)
        internal val titleTextView = itemView.findViewById<TextView>(R.id.mediaTitle)
        internal val abstractTextView = itemView.findViewById<TextView>(R.id.mediaAbstract)

        init {
            itemView.setOnClickListener(this)
        }

        // TODO: Write a helper method to help set up the onBindViewHolder method

        override fun onClick(v: View?) {
            // TODO: Get selected article
            val article = articles[absoluteAdapterPosition]
            val intent = Intent(context, DetailActivity::class.java)
            // TODO: Navigate to Details screen and pass selected article
            intent.putExtra(ARTICLE_EXTRA, article)
            context.startActivity(intent)
        }
    }

}