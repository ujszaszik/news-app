package com.planday.newsapp.features.news

import com.planday.network.operation.networkFlow
import com.planday.newsapp.coroutines.ResourceFlow
import com.planday.newsapp.features.news.list.model.NewsListModel
import javax.inject.Inject

class NewsRepository @Inject constructor(
    private val service: NewsService
) : INewsRepository {

    override fun getNewsByKeyword(keyword: String, pageNumber: Long): ResourceFlow<NewsListModel> =
        networkFlow {
            service.getNewsByKeyword(
                keyword = keyword,
                pageNumber = pageNumber
            )
        }

    override fun getTopHeadlines(pageNumber: Long): ResourceFlow<NewsListModel> =
        networkFlow { service.getTopHeadlines(pageNumber = pageNumber) }
}