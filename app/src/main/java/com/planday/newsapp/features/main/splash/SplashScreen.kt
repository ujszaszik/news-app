package com.planday.newsapp.features.main.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.planday.compose.layout.DefaultSpacer
import com.planday.compose.resources.Colors
import com.planday.compose.resources.Dimens
import com.planday.compose.resources.Fonts

@Composable
fun SplashScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Colors.appBlue),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = SplashTexts.APP_TITLE,
            color = Colors.white,
            fontWeight = FontWeight.Bold,
            fontFamily = Fonts.enduranceFamily,
            fontSize = 48.sp
        )

        DefaultSpacer()

        Text(
            text = SplashTexts.APP_FROM,
            color = Colors.white,
            fontFamily = Fonts.enduranceFamily,
            fontSize = Dimens.newsTitleTextSize
        )

    }
}