package com.planday.newsapp.validation.text

import com.planday.extension.empty
import com.planday.newsapp.validation.Validator

interface TextValidator : Validator<String?> {

    val errorMessage: String
        get() = String.empty
}