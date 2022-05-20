package com.planday.newsapp.features.news.search.ui

import androidx.lifecycle.ViewModel
import com.planday.newsapp.coroutines.InputFlow
import com.planday.newsapp.coroutines.clear
import com.planday.newsapp.coroutines.launch
import com.planday.newsapp.coroutines.mutableStateFlow
import com.planday.newsapp.features.news.search.SearchInputValidator
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class NewsSearchViewModel @Inject constructor() : ViewModel() {

    internal var searchedTextInput = InputFlow(SearchInputValidator)

    private val _newsAction = mutableStateFlow<Action>()
    val newsAction: StateFlow<Action?> = _newsAction

    fun onSearchTextChange(newValue: String) {
        searchedTextInput.onValueChanged(newValue)
    }

    fun onSearchRequest() {
        if (searchedTextInput.isValid()) {
            launch {
                val keyword = searchedTextInput.actualValue()
                _newsAction.emit(Action.SearchNews(keyword))
            }
        }
    }

    fun onBrowseLatestNewsRequest() {
        launch { _newsAction.emit(Action.BrowseLatestNews) }
    }

    fun resetKeyword() = _newsAction.clear()

    sealed class Action {
        class SearchNews(val keyword: String) : Action()
        object BrowseLatestNews : Action()
    }

}