package com.planday.newsapp.navigation.graph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.planday.newsapp.features.main.splash.SplashHost
import com.planday.newsapp.features.news.browser.NEWS_BROWSER_URL_KEY
import com.planday.newsapp.features.news.browser.NewsBrowserHost
import com.planday.newsapp.features.news.details.ui.NEWS_DETAILS_KEY
import com.planday.newsapp.features.news.details.ui.NewsDetailsHost
import com.planday.newsapp.features.news.list.model.NewsItem
import com.planday.newsapp.features.news.list.ui.NEWS_SEARCH_KEYWORD_KEY
import com.planday.newsapp.features.news.list.ui.NewsListHost
import com.planday.newsapp.features.news.search.ui.NewsSearchHost
import com.planday.newsapp.navigation.arguments.retainEncodedParam
import com.planday.newsapp.navigation.arguments.retainParam
import com.planday.newsapp.navigation.composable

val LocalNavController =
    compositionLocalOf<NavHostController> { error("LocalComposition NavController not present") }

@Composable
fun ApplicationGraph() {

    val navController = LocalNavController.current

    NavHost(navController = navController, startDestination = SplashHost.route) {

        composable(SplashHost) {
            SplashHost()
        }

        composable(NewsSearchHost) {
            NewsSearchHost()
        }

        composable(NewsListHost) {
            val keyword = it.retainParam<String>(NEWS_SEARCH_KEYWORD_KEY)
            NewsListHost(keyword)
        }

        composable(NewsDetailsHost) {
            val newsItem = it.retainEncodedParam<NewsItem>(NEWS_DETAILS_KEY)
            NewsDetailsHost(newsItem)
        }

        composable(NewsBrowserHost) {
            val url = it.retainEncodedParam<String>(NEWS_BROWSER_URL_KEY)
            NewsBrowserHost(url)
        }
    }

}