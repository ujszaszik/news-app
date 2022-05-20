package com.planday.newsapp.features.news.list.ui

import androidx.lifecycle.ViewModel
import com.planday.extension.isZero
import com.planday.newsapp.coroutines.ResourceFlow
import com.planday.newsapp.coroutines.ResourceFlowMediator
import com.planday.newsapp.coroutines.emitValue
import com.planday.newsapp.coroutines.mutableStateFlow
import com.planday.newsapp.features.news.INewsRepository
import com.planday.newsapp.features.news.list.model.NewsItem
import com.planday.newsapp.features.news.list.model.NewsListModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel @Inject constructor(
    private val repository: INewsRepository
) : ViewModel() {

    private var currentElements = mutableListOf<NewsItem>()
    private var currentPageNumber = 0L
    private var pageSize = 100

    private val _isLoading = mutableStateFlow<Boolean>()
    val isLoading: StateFlow<Boolean?> = _isLoading

    val isRefreshing = _isLoading.transform<Boolean?, Boolean> { isLoading ->
        true == isLoading && currentPageNumber.isZero()
    }

    private val _itemDetails = mutableStateFlow<NewsItemDetails>()
    val itemDetails: StateFlow<NewsItemDetails?> = _itemDetails

    private val _errorMessage = mutableStateFlow<String>()
    val errorMessage: StateFlow<String?> = _errorMessage

    fun loadNews(keyword: String) {
        ResourceFlowMediator(
            source = getRemoteSource(keyword),
            viewModel = this,
            loadingFlow = _isLoading,
            onSuccess = {
                currentElements.addAll(it.items)
                val isLastPage = it.itemsCount <= currentPageNumber * pageSize
                emitValue(_itemDetails, NewsItemDetails(currentElements, it.itemsCount, isLastPage))
            },
            onError = { emitValue(_errorMessage, it) }
        ).begin()
    }

    private fun getRemoteSource(keyword: String): ResourceFlow<NewsListModel> {
        return if (keyword.isEmpty()) repository.getTopHeadlines(++currentPageNumber)
        else repository.getNewsByKeyword(keyword, ++currentPageNumber)
    }

    class NewsItemDetails(
        val items: List<NewsItem>,
        val totalCount: Long,
        val finishedLoading: Boolean
    )
}