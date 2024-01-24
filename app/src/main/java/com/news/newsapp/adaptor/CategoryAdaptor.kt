package com.news.newsapp.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.news.newsapp.R
import com.news.newsapp.models.Articles

class CategoryAdaptor(private val context : Context, private val categories : List<String>) : RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {

    companion object {
        var selectedCategory: String = ""
    }

    init {
        if (categories.isNotEmpty()) {
            selectedCategory = categories[0]
        }
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val categoryView : TextView = itemView.findViewById(R.id.category_name)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(view: View) {
            selectedCategory = categories[adapterPosition]
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_template, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val category = categories[position]
        holder.categoryView.text = category

        if (selectedCategory == category) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.purple_200))
            holder.categoryView.setTextColor(ContextCompat.getColor(context, R.color.white))
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
            holder.categoryView.setTextColor(ContextCompat.getColor(context, R.color.black))
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
