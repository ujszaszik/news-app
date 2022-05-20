package com.planday.newsapp.features.news.search

import com.planday.newsapp.validation.isValidForAll
import com.planday.newsapp.validation.text.TextValidator
import com.planday.newsapp.validation.text.content.TextContentValidator
import com.planday.newsapp.validation.text.length.TextLengthRange
import com.planday.newsapp.validation.text.length.TextLengthValidator

object SearchInputValidator : TextValidator {

    private val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9') + ('_')
    private val contentValidator = TextContentValidator(allowedChars)

    private const val ALLOWED_MIN_CHARS = 1
    private const val ALLOWED_MAX_CHARS = 30
    private val allowedLengthRange = TextLengthRange.of(ALLOWED_MIN_CHARS, ALLOWED_MAX_CHARS)
    private val lengthValidator = TextLengthValidator(allowedLengthRange)

    override val errorMessage: String
        get() = "Can only contain letters, numbers, or underscore.\n" +
                "Length must be between $ALLOWED_MIN_CHARS and $ALLOWED_MAX_CHARS characters."

    override fun isValid(value: String?): Boolean {
        return value?.let {
            isValidForAll(it, contentValidator, lengthValidator)
        } ?: false
    }
}