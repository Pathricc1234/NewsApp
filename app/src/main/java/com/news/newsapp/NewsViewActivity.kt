package com.news.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView

class NewsViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_view)

        val webView: WebView = findViewById(R.id.webView)

        val newsUrl = intent.getStringExtra("news_url")

        if (!newsUrl.isNullOrBlank()) {
            webView.loadUrl(newsUrl)
        }
        else {
            finish()
        }
    }
}