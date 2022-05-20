package com.planday.newsapp.features.news.list.model

import com.planday.network.mapper.DataMappedFrom
import com.planday.newsapp.features.news.list.network.NewsListResponse
import com.squareup.moshi.JsonClass

@DataMappedFrom(NewsListResponse::class)
class NewsListModel(
    val itemsCount: Long,
    val items: List<NewsItem>
)

@JsonClass(generateAdapter = true)
data class NewsItem(
    val title: String,
    val author: String,
    val description: String,
    val publishedAt: String,
    val sourceOfNews: String,
    val sourceUrl: String,
    val imageUrl: String?
)