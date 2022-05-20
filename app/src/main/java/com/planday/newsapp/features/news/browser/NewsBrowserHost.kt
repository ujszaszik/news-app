package com.planday.newsapp.features.news.browser

import androidx.compose.runtime.Composable
import com.planday.compose.web.WebScreen
import com.planday.newsapp.navigation.graph.LocalNavController
import com.planday.newsapp.navigation.host.Host
import com.planday.newsapp.navigation.host.HostType
import com.planday.newsapp.navigation.host.acceptParam

const val NEWS_BROWSER_URL_KEY = "NewsBrowser::URL"

val NewsBrowserHost = Host(
    route = "NewsBrowserHost",
    title = "Browse",
    type = HostType.SUB
).acceptParam(NEWS_BROWSER_URL_KEY)

@Composable
fun NewsBrowserHost(url: String?) {

    val navController = LocalNavController.current

    url?.let {
        WebScreen(url = it)
    } ?: navController.popBackStack()

}