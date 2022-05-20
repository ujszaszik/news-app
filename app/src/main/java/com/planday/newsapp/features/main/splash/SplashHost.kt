package com.planday.newsapp.features.main.splash

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.planday.newsapp.features.news.search.ui.navigateToSearch
import com.planday.newsapp.navigation.graph.LocalNavController
import com.planday.newsapp.navigation.host.Host

val SplashHost = Host(route = "SplashHost")

@Composable
fun SplashHost(viewModel: SplashViewModel = hiltViewModel()) {

    val isSplashFinished = viewModel.isSplashFinished.observeAsState().value ?: false

    if (isSplashFinished) {
        LocalNavController.current.navigateToSearch()
    }

    SplashScreen()
}