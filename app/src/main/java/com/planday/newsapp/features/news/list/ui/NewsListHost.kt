package com.planday.newsapp.features.news.list.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import com.planday.compose.dialog.ErrorDialog
import com.planday.compose.progress.ProgressBar
import com.planday.compose.resources.Strings
import com.planday.newsapp.coroutines.collectAsStateValue
import com.planday.newsapp.features.news.details.ui.NewsDetailsHost
import com.planday.newsapp.navigation.graph.LocalNavController
import com.planday.newsapp.navigation.host.*

const val NEWS_SEARCH_KEYWORD_KEY = "NewsList::SearchKeyword"

val NewsListHost = Host(
    route = "NewsList",
    title = "News",
    type = HostType.SUB
).acceptParam(NEWS_SEARCH_KEYWORD_KEY)

@Composable
fun NewsListHost(keyword: String?, viewModel: NewsListViewModel = hiltViewModel()) {

    val navController = LocalNavController.current

    LaunchedEffect(key1 = keyword) {
        keyword?.let {
            viewModel.loadNews(it)
        } ?: navController.popBackStack()
    }

    val isLoading = viewModel.isLoading.collectAsStateValue() ?: false
    val isRefreshing = viewModel.isRefreshing.collectAsStateValue() ?: false
    val itemDetails = viewModel.itemDetails.collectAsStateValue()
    val errorMessage = viewModel.errorMessage.collectAsStateValue()

    errorMessage?.let { ErrorDialog(title = Strings.ERROR, message = it) }

    when {
        itemDetails != null -> {
            NewsListScreen(
                isLoading = isLoading,
                hasFinishedLoading = itemDetails.finishedLoading,
                keyword = keyword!!,
                itemsList = itemDetails.items,
                totalCount = itemDetails.totalCount,
                onItemClicked = {
                    navController.navigate(NewsDetailsHost.withEncodedData(it))
                },
                onLoadMore = { viewModel.loadNews(keyword) },
                isRefreshing = isRefreshing,
                onRefresh = { navController.navigate(NewsListHost.withData(keyword)) }
            )
        }
        else -> ProgressBar()
    }


}