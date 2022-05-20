package com.planday.newsapp.navigation.host

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class OptionsMenuItem(
    val iconId: Int,
    val destination: Host
)