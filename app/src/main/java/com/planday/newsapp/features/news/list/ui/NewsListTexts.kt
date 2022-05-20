package com.planday.newsapp.features.news.list.ui

object NewsListTexts {

    fun headerText(keyword: String): String {
        return if (keyword.isEmpty()) "Latest news"
        else "Results for: $keyword"
    }

    fun totalCount(count: Long) = "Count: $count"
}