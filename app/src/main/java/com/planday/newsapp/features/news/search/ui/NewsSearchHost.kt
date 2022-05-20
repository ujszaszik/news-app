package com.planday.newsapp.features.news.search.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.planday.extension.empty
import com.planday.newsapp.coroutines.collectAsStateValue
import com.planday.newsapp.features.news.list.ui.NewsListHost
import com.planday.newsapp.navigation.graph.LocalNavController
import com.planday.newsapp.navigation.host.BackPressStrategy
import com.planday.newsapp.navigation.host.Host
import com.planday.newsapp.navigation.host.HostType
import com.planday.newsapp.navigation.host.withData

val NewsSearchHost = Host(
    route = "NewsSearch",
    title = "Search News",
    type = HostType.MAIN,
    backPressStrategy = BackPressStrategy.EXIT_APPLICATION
)

fun NavController.navigateToSearch() =
    navigate(NewsSearchHost.route) {
        popUpTo(NewsSearchHost.route) { inclusive = true }
    }

@Composable
fun NewsSearchHost(viewModel: NewsSearchViewModel = hiltViewModel()) {

    val searchInputError = viewModel.searchedTextInput.collectErrorState()

    val newsAction = viewModel.newsAction.collectAsStateValue()
    val navController = LocalNavController.current

    LaunchedEffect(newsAction) {
        newsAction?.let {
            val keyword = when (it) {
                is NewsSearchViewModel.Action.SearchNews -> it.keyword
                is NewsSearchViewModel.Action.BrowseLatestNews -> String.empty
            }
            viewModel.resetKeyword()
            navController.navigate(NewsListHost.withData(keyword))
        }
    }

    NewsSearchScreen(
        errorMessage = searchInputError,
        onTextChanged = { viewModel.onSearchTextChange(it) },
        onSearchRequested = { viewModel.onSearchRequest() },
        onBrowseLatestNewsRequested = { viewModel.onBrowseLatestNewsRequest() }
    )
}