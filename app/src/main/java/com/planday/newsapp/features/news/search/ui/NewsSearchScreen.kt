package com.planday.newsapp.features.news.search.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.OpenInBrowser
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.planday.compose.button.PrimaryButton
import com.planday.compose.button.SecondaryButton
import com.planday.compose.input.InputField
import com.planday.compose.layout.CenteredColumn
import com.planday.compose.layout.DoubleSpacer
import com.planday.newsapp.features.main.util.LocalKeyboardManager

@Composable
fun NewsSearchScreen(
    errorMessage: String? = null,
    onTextChanged: (String) -> Unit,
    onSearchRequested: () -> Unit,
    onBrowseLatestNewsRequested: () -> Unit
) {

    val keyboardManager = LocalKeyboardManager.current

    CenteredColumn {

        InputField(
            label = NewsSearchTexts.SEARCH_HINT,
            errorMessage = errorMessage,
            onTextChanged = { onTextChanged(it) }
        )

        PrimaryButton(
            label = NewsSearchTexts.SEARCH_BUTTON_LABEL,
            onClick = {
                keyboardManager.hide()
                onSearchRequested()
            },
            icon = Icons.Default.Search
        )

        DoubleSpacer()

        SecondaryButton(
            label = NewsSearchTexts.BROWSE_LATEST_NEWS_LABEL,
            onClick = {
                keyboardManager.hide()
                onBrowseLatestNewsRequested()
            },
            icon = Icons.Default.OpenInBrowser
        )
    }
}