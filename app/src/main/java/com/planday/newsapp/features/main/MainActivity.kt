package com.planday.newsapp.features.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.planday.newsapp.coroutines.collectAsStateValue
import com.planday.newsapp.features.main.util.ActionBarChannel
import com.planday.newsapp.features.main.util.ActionBarEvent
import com.planday.newsapp.features.main.util.KeyboardManager
import com.planday.newsapp.features.main.util.LocalKeyboardManager
import com.planday.newsapp.features.news.NewsRepository
import com.planday.newsapp.features.news.search.ui.navigateToSearch
import com.planday.newsapp.navigation.graph.LocalNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    @Inject
    lateinit var repository: NewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val navController = rememberNavController()
            val keyboardManager = KeyboardManager(this)

            val exitRequest = viewModel.onExitRequest.collectAsStateValue()
            LaunchedEffect(exitRequest) {
                if (true == exitRequest) finishAffinity().run { viewModel.resetExitRequest() }
            }

            val actionBarEvent = ActionBarChannel.receive().collectAsStateValue()
            when (actionBarEvent) {
                is ActionBarEvent.NavigateToSearchPage -> navController.navigateToSearch()
                is ActionBarEvent.CloseApplication -> finishAffinity()
                else -> Unit
            }
            actionBarEvent?.let { ActionBarChannel.reset() }

            CompositionLocalProvider(
                LocalNavController provides navController,
                LocalKeyboardManager provides keyboardManager
            ) { MainHost(viewModel) }
        }
    }

    override fun onBackPressed() {
        viewModel.onBackPressed()
    }

}