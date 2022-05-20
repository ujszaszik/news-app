package com.planday.newsapp.features.news.list.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import com.planday.compose.layout.CenteredColumn
import com.planday.compose.paging.PagingColumn
import com.planday.compose.progress.ProgressBar
import com.planday.compose.resources.Dimens
import com.planday.newsapp.features.news.list.model.NewsItem

@Composable
fun NewsListScreen(
    isLoading: Boolean,
    hasFinishedLoading: Boolean,
    keyword: String,
    itemsList: List<NewsItem>,
    totalCount: Long,
    onItemClicked: (NewsItem) -> Unit,
    onLoadMore: () -> Unit,
    isRefreshing: Boolean,
    onRefresh: () -> Unit,
) {

    CenteredColumn {

        SwipeRefresh(
            state = rememberSwipeRefreshState(isRefreshing),
            onRefresh = { onRefresh() },
        ) {

            Column {

                NewsListHeader(
                    keyword = keyword,
                    totalCount = totalCount
                )

                PagingColumn(
                    modifier = Modifier
                        .padding(horizontal = Dimens.paddingHalf)
                        .padding(top = Dimens.paddingDouble),
                    items = itemsList,
                    itemContent = { item, modifier ->
                        NewsListItemScreen(
                            modifier = modifier,
                            keyword = keyword,
                            newsItem = item,
                            onItemClick = { onItemClicked(it) }
                        )
                    },
                    emptyContent = { NewsListEmptyScreen() },
                    loadingContent = { ProgressBar() },
                    currentlyLoading = isLoading,
                    finishedLoading = hasFinishedLoading,
                    onLoadMore = onLoadMore
                )
            }
        }
    }
}