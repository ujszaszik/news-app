package com.planday.extension

val String.Companion.empty: String
    get() = ""

val String.Companion.space: String
    get() = " "

val String.Companion.notAvailable: String
    get() = "N/A"

fun String?.indexesOf(keyword: String): List<IntRange> =
    keyword.toRegex(RegexOption.IGNORE_CASE)
        .findAll(this ?: String.empty)
        .map { it.range }
        .toList()