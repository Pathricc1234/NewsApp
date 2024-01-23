package com.news.newsapp.models

import com.google.gson.annotations.SerializedName

data class Articles(
    @SerializedName("source")
    val source : Source,
    @SerializedName("author")
    val author : Any?,
    @SerializedName("title")
    val title : String,
    @SerializedName("description")
    val description : String?,
    @SerializedName("url")
    val url : String,
    @SerializedName("urlToImage")
    val urlToImage : String,
    @SerializedName("publishedAt")
    val publishedAt : String,
    @SerializedName("content")
    val content : String?
)