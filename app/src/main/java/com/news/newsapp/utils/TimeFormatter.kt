package com.news.newsapp.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object TimeFormatter {
    fun timeFormatter(jsonTime: String?): String {
        val jsonFormat = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        val dateTime = LocalDateTime.parse(jsonTime, jsonFormat)
        val simpleTimeFormatter = DateTimeFormatter.ofPattern("dd MMM, yyyy HH:mm:ss")
        return dateTime.format(simpleTimeFormatter)
    }
}
