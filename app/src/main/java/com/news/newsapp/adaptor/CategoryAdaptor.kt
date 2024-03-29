package com.news.newsapp.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.news.newsapp.R
import com.news.newsapp.utils.SelectedCategory

class CategoryAdaptor(private val context : Context, private val categories : List<String>, private val categoryListener : SelectedCategory) : RecyclerView.Adapter<CategoryAdaptor.ViewHolder>() {

    var selectedCategory : String = ""

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
            categoryListener.onCategorySelected(selectedCategory)
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
            holder.itemView.findViewById<CardView>(R.id.cardview).setCardBackgroundColor(ContextCompat.getColor(context, R.color.purple_500))
            holder.categoryView.setTextColor(ContextCompat.getColor(context, R.color.white))
        }
        else {
            holder.itemView.findViewById<CardView>(R.id.cardview).setCardBackgroundColor(ContextCompat.getColor(context, android.R.color.white))
            holder.categoryView.setTextColor(ContextCompat.getColor(context, R.color.black))
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}
