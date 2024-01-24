package com.news.newsapp.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.news.newsapp.R
import com.news.newsapp.models.Articles

class CategoryAdaptor(private val context : Context, private val categories : List<String>) : RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {
    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val categoryView : TextView = itemView.findViewById(R.id.category_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_template,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryView.text = categories[position]
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
