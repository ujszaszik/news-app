package com.planday.newsapp.formatter

import android.annotation.SuppressLint
import com.planday.extension.notAvailable
import java.text.SimpleDateFormat

@SuppressLint("SimpleDateFormat")
object DateTimeFormatter {

    private val parser = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    private val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")

    fun format(dateTimeText: String): String {
        return parser.parse(dateTimeText)?.let {
            formatter.format(it)
        } ?: String.notAvailable
    }
}