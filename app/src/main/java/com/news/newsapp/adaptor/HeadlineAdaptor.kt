package com.news.newsapp.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.news.newsapp.R
import com.news.newsapp.models.Articles
import com.news.newsapp.utils.Constant
import com.news.newsapp.utils.TimeFormatter

class HeadlineAdaptor(private val context: Context, private val news: List<Articles>): RecyclerView.Adapter<HeadlineAdaptor.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.news_img)
        val headlineView: TextView = itemView.findViewById(R.id.top_news_headline)
        val sourceView : TextView = itemView.findViewById(R.id.top_news_source)
        val authorView: TextView = itemView.findViewById(R.id.top_news_author)
        val datePublishedView : TextView = itemView.findViewById(R.id.top_news_publish)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.headline_template,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currNews = news[position]
        Glide.with(context).load(currNews.urlToImage).error(Constant.customImg).into(holder.imageView)
        holder.headlineView.text = currNews.title
        holder.sourceView.text = currNews.source.name
        if(currNews.author != null){
            holder.authorView.text = currNews.author.toString()
            holder.authorView.visibility = View.VISIBLE
        }
        else{
            holder.authorView.text = ""
            holder.authorView.visibility = View.GONE
        }
        val publishedTime = TimeFormatter.timeFormatter(currNews.publishedAt)
        holder.datePublishedView.text = publishedTime
    }

    override fun getItemCount(): Int {
        return news.size
    }
}