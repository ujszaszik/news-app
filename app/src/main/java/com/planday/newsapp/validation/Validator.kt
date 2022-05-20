package com.planday.newsapp.validation

interface Validator<Type> {

    fun isValid(value: Type): Boolean
}