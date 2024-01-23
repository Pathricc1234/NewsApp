package com.news.newsapp.api

import com.news.newsapp.models.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("v2/top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("page") page : Int,
        @Query("apiKey") apiKey : String
    ): Call<News>

    @GET("v2/everything")
    fun getAllNews(
        @Query("q") q:String,
        @Query("page") page : Int
    ): Call<News>
}