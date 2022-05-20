package com.planday.newsapp.features.news.list.network

import com.planday.network.mapper.DataMapper
import com.planday.newsapp.features.news.list.mapper.NewsListMapper
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@DataMapper(NewsListMapper::class)
data class NewsListResponse(
    val totalResults: Long,
    val articles: List<NewsListItem>
)


@JsonClass(generateAdapter = true)
data class NewsListItem(
    val title: String,
    val author: String?,
    val description: String?,
    val publishedAt: String,
    val source: Source,
    val url: String,
    val urlToImage: String?
)

@JsonClass(generateAdapter = true)
data class Source(
    val id: String?,
    val name: String
)