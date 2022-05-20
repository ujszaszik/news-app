package com.planday.newsapp.features.news.list.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.planday.compose.resources.Dimens

@Composable
fun NewsListHeader(
    keyword: String,
    totalCount: Long
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = Dimens.paddingDefault,
                start = Dimens.paddingDouble,
                end = Dimens.paddingDouble
            )
    ) {

        Text(text = NewsListTexts.headerText(keyword))

        Spacer(modifier = Modifier.weight(1f))

        Text(text = NewsListTexts.totalCount(totalCount))
    }
}