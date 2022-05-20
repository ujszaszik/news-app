package com.planday.compose.resources

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object Dimens {

    // PADDING
    val paddingLarge = 32.dp
    val paddingDouble = 16.dp
    val paddingDefault = 8.dp
    val paddingHalf = 4.dp

    private val paddingDefaultHorizontal = 20.dp
    private val paddingDefaultVertical = 12.dp
    val paddingDefaultValues = PaddingValues(
        start = paddingDefaultHorizontal,
        top = paddingDefaultVertical,
        end = paddingDefaultHorizontal,
        bottom = paddingDefaultVertical
    )

    // CARD
    val cardCornerRadius = 8.dp
    val cardElevation = 6.dp

    // SEPARATOR
    val defaultSeparatorHeight = 1.dp

    // TEXT
    val smallTextSize = 13.sp
    val defaultTextSize = 15.sp
    val highlightTextSize = 16.sp
    val newsDescriptionTextSize = 18.sp
    val newsTitleTextSize = 20.sp
    val appBarTextSize = 24.sp

    // ICON
    val largerIconSize = 24.dp
    val emptyListIconSize = 240.dp

    // LOGO
    val logoHeight = 150.dp
    val logoWidth = 100.dp
}