package com.planday.newsapp.features.news

import com.planday.newsapp.coroutines.ResourceFlow
import com.planday.newsapp.features.news.list.model.NewsListModel

interface INewsRepository {

    fun getNewsByKeyword(keyword: String, pageNumber: Long): ResourceFlow<NewsListModel>

    fun getTopHeadlines(pageNumber: Long): ResourceFlow<NewsListModel>
}