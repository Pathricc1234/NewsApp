package com.news.newsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.news.newsapp.adaptor.HeadlineAdaptor
import com.news.newsapp.api.ApiClient
import com.news.newsapp.models.News
import com.news.newsapp.utils.Constant.Companion.API_KEY
import retrofit2.Response
import javax.security.auth.callback.Callback

class NewsActivity : AppCompatActivity() {

    lateinit var headlineRecView : RecyclerView
    lateinit var headlineAdapter : HeadlineAdaptor

    lateinit var allNewsRecView : RecyclerView
    lateinit var allNewsAdapter : HeadlineAdaptor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        headlineRecView = findViewById(R.id.headline_news)
        allNewsRecView = findViewById(R.id.all_news)

        getHeadlines()
    }

    private fun getHeadlines(){
        val news = ApiClient.newsInstance.getTopHeadlines("us", 1, API_KEY)
        news.enqueue(object : retrofit2.Callback<News> {
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news = response.body()
                if(news != null){
                    headlineRecView.layoutManager = LinearLayoutManager(this@NewsActivity, LinearLayoutManager.HORIZONTAL,false)
                    headlineAdapter = HeadlineAdaptor(this@NewsActivity, news.articles)
                    headlineRecView.adapter = headlineAdapter
                    getAllNews()
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("Log: ", "Error Getting News")
            }
        })
    }

    private fun getAllNews(){
        val news = ApiClient.newsInstance.getAllNews("bank mandiri",1)
        news.enqueue(object : retrofit2.Callback<News>{
            override fun onResponse(call: retrofit2.Call<News>, response: Response<News>) {
                val news = response.body()
                if(news != null){
                    allNewsRecView.layoutManager = LinearLayoutManager(this@NewsActivity,LinearLayoutManager.VERTICAL,false)
                    allNewsAdapter = HeadlineAdaptor(this@NewsActivity, news.articles)
                    allNewsRecView.adapter = allNewsAdapter
                }
            }

            override fun onFailure(call: retrofit2.Call<News>, t: Throwable) {
                Log.d("Log: ", "Error Getting News")
            }
        })
    }
}
