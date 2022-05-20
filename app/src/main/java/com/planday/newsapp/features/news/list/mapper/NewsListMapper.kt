package com.planday.newsapp.features.news.list.mapper

import com.planday.extension.notAvailable
import com.planday.network.mapper.BaseMapper
import com.planday.newsapp.features.news.list.model.NewsItem
import com.planday.newsapp.features.news.list.model.NewsListModel
import com.planday.newsapp.features.news.list.network.NewsListItem
import com.planday.newsapp.features.news.list.network.NewsListResponse
import com.planday.newsapp.formatter.DateTimeFormatter

class NewsListMapper : BaseMapper<NewsListResponse, NewsListModel> {

    override fun map(remote: NewsListResponse): NewsListModel {
        val items = remote.articles.map { RepoItemMapper.map(it) }
        return NewsListModel(remote.totalResults, items)
    }
}

object RepoItemMapper : BaseMapper<NewsListItem, NewsItem> {

    override fun map(remote: NewsListItem): NewsItem {
        return NewsItem(
            title = remote.title,
            author = remote.author ?: String.notAvailable,
            description = remote.description ?: String.notAvailable,
            publishedAt = DateTimeFormatter.format(remote.publishedAt),
            sourceOfNews = remote.source.name,
            sourceUrl = remote.url,
            imageUrl = remote.urlToImage
        )
    }
}