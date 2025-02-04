package com.barengsaya.animeview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ArticleAdapter(
    private val articles: List<Article>
) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.article_title)
        val overview: TextView = itemView.findViewById(R.id.article_overview)
        val image: ImageView = itemView.findViewById(R.id.article_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return ArticleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.title.text = article.title
        holder.overview.text = article.overview
        holder.image.setImageResource(article.imageResId)

        // Mengirim data lengkap ke DetailActivity
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("title", article.title)
            intent.putExtra("overview", article.overview)
            intent.putExtra("imageResId", article.imageResId)
            intent.putExtra("longDescription", article.longDescription)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}
