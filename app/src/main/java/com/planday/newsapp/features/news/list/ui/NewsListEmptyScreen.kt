package com.planday.newsapp.features.news.list.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.planday.compose.layout.CenteredColumn
import com.planday.compose.resources.Dimens
import com.planday.newsapp.R
import kotlinx.coroutines.delay

private const val EMPTY_LIST_DELAY = 750L

@Composable
fun NewsListEmptyScreen() {

    var showScreen by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = showScreen) {
        delay(EMPTY_LIST_DELAY)
        showScreen = true
    }

    if (showScreen) {
        CenteredColumn(modifier = Modifier.fillMaxSize()) {
            Row(modifier = Modifier.size(Dimens.emptyListIconSize)) {
                val lottieSpec = LottieCompositionSpec.RawRes(R.raw.empty_box)
                val composition by rememberLottieComposition(lottieSpec)
                LottieAnimation(
                    composition = composition,
                    iterations = 1
                )
            }
        }
    }
}