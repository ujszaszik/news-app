package com.planday.newsapp.features.news.details.ui

import androidx.compose.runtime.Composable
import com.planday.newsapp.features.news.browser.NewsBrowserHost
import com.planday.newsapp.features.news.list.model.NewsItem
import com.planday.newsapp.navigation.graph.LocalNavController
import com.planday.newsapp.navigation.host.Host
import com.planday.newsapp.navigation.host.HostType
import com.planday.newsapp.navigation.host.acceptParam
import com.planday.newsapp.navigation.host.withEncodedData

const val NEWS_DETAILS_KEY = "NewsDetails::NewsDetailKey"

val NewsDetailsHost = Host(
    route = "NewsDetailsHost",
    title = "Details",
    type = HostType.SUB
).acceptParam(NEWS_DETAILS_KEY)

@Composable
fun NewsDetailsHost(newsItem: NewsItem?) {

    val navController = LocalNavController.current

    newsItem?.let {
        NewsDetailsScreen(
            newsItem = it,
            onBrowseRequest = { url ->
                navController.navigate(NewsBrowserHost.withEncodedData(url))
            }
        )
    }

}