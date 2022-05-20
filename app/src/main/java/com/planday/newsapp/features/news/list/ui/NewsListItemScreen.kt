package com.planday.newsapp.features.news.list.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.planday.compose.image.NetworkImage
import com.planday.compose.image.NetworkImageSize
import com.planday.compose.layout.DefaultSpacer
import com.planday.compose.layout.DoubleSpacer
import com.planday.compose.resources.Colors
import com.planday.compose.resources.Dimens
import com.planday.compose.resources.Fonts
import com.planday.newsapp.features.news.list.model.NewsItem
import com.planday.newsapp.formatter.TextAnnotator

@Composable
fun NewsListItemScreen(
    modifier: Modifier = Modifier,
    newsItem: NewsItem,
    keyword: String,
    onItemClick: (NewsItem) -> Unit
) {

    Card(
        modifier = modifier.padding(Dimens.paddingHalf),
        shape = RoundedCornerShape(Dimens.cardCornerRadius),
        elevation = Dimens.cardElevation
    ) {

        Column(modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(Dimens.cardCornerRadius))
            .clickable { onItemClick.invoke(newsItem) }
            .padding(horizontal = Dimens.paddingDefault)
        ) {

            DoubleSpacer()

            NetworkImage(newsItem.imageUrl, NetworkImageSize.MEDIUM)

            DefaultSpacer()

            Text(
                text = TextAnnotator.getHighlightedText(newsItem.title, keyword),
                textAlign = TextAlign.Start,
                fontFamily = Fonts.enduranceFamily,
                fontWeight = FontWeight.Bold,
                color = Colors.blue,
                fontSize = Dimens.newsTitleTextSize,
            )

            DefaultSpacer()

            Text(
                text = newsItem.publishedAt,
                textAlign = TextAlign.Start,
                fontFamily = Fonts.enduranceFamily,
                color = Colors.gray,
                fontSize = Dimens.newsDescriptionTextSize,
                fontStyle = FontStyle.Italic
            )

            DoubleSpacer()
        }

    }

}