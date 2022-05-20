package com.planday.newsapp.features.news.details.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Web
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.planday.compose.button.PrimaryButton
import com.planday.compose.image.NetworkImage
import com.planday.compose.image.NetworkImageSize
import com.planday.compose.layout.DefaultSpacer
import com.planday.compose.layout.DoubleSpacer
import com.planday.compose.layout.LargeSpacer
import com.planday.compose.resources.Colors
import com.planday.compose.resources.Dimens
import com.planday.compose.resources.Fonts
import com.planday.compose.scroll.enableVerticalScroll
import com.planday.compose.separator.VerticalSeparator
import com.planday.newsapp.features.news.details.NewsDetailsTexts
import com.planday.newsapp.features.news.list.model.NewsItem

@Composable
fun NewsDetailsScreen(
    newsItem: NewsItem,
    onBrowseRequest: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .enableVerticalScroll()
            .padding(Dimens.paddingDefault)
    ) {

        LargeSpacer()

        NetworkImage(newsItem.imageUrl, NetworkImageSize.LARGE)

        DefaultSpacer()

        Text(
            text = newsItem.title,
            textAlign = TextAlign.Start,
            fontFamily = Fonts.enduranceFamily,
            fontWeight = FontWeight.Bold,
            color = Colors.blue,
            fontSize = Dimens.newsTitleTextSize,
        )

        DefaultSpacer()

        Text(
            text = newsItem.description,
            textAlign = TextAlign.Start,
            fontFamily = Fonts.enduranceFamily,
            color = Colors.steelGray,
            fontSize = Dimens.newsDescriptionTextSize,
        )

        DefaultSpacer()

        Text(
            modifier = Modifier.wrapContentWidth(Alignment.Start),
            text = "Author: ${newsItem.author}",
            textAlign = TextAlign.Start,
            fontFamily = Fonts.enduranceFamily,
            color = Colors.steelGray,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )

        DefaultSpacer()

        Text(
            modifier = Modifier.wrapContentWidth(Alignment.Start),
            text = "Source: ${newsItem.sourceOfNews}",
            textAlign = TextAlign.Start,
            fontFamily = Fonts.enduranceFamily,
            color = Colors.steelGray,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
        )

        DoubleSpacer()

        VerticalSeparator()

        DefaultSpacer()

        PrimaryButton(
            label = NewsDetailsTexts.SOURCE_URL_LABEL,
            icon = Icons.Default.Web,
            onClick = { onBrowseRequest(newsItem.sourceUrl) })

        DoubleSpacer()

    } // TopCenterColumn

}