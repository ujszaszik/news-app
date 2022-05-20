package com.planday.compose.resources

import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

object Colors {

    val white = Color(0xFFFFFFFF)
    val blue = Color(0xFF3399CC)
    val appBlue = Color(0xFF1A73E8)
    val red = Color(0xFFFF6917)
    val gray = Color(0xFFC1C1C1)
    val steelGray = Color(0xFF767676)

    @Composable
    fun inputFieldColors() = TextFieldDefaults.textFieldColors(
        textColor = appBlue,
        disabledTextColor = gray,
        focusedLabelColor = steelGray,
        unfocusedLabelColor = steelGray,
        focusedIndicatorColor = appBlue,
        unfocusedIndicatorColor = gray
    )
}