    package com.news.newsapp.api

    import com.news.newsapp.utils.Constant.Companion.BASE_URL
    import retrofit2.Retrofit
    import retrofit2.converter.gson.GsonConverterFactory

    object ApiClient {

        val newsInstance : NewsInterface

        init {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
            newsInstance = retrofit.create(NewsInterface::class.java)
        }
    }