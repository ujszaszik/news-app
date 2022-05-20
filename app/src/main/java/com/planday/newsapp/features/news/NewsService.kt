package com.planday.newsapp.features.news

import com.planday.network.call.Resource
import com.planday.newsapp.features.news.list.model.NewsListModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

// In a real-world scenario I would hide this information with CMake and Native C++ libs
const val AUTH_HEADER = "Authorization: 7c669f20fa3f4d1a92d93eed09a397c6"

interface NewsService {

    @Headers(AUTH_HEADER)
    @GET("everything")
    suspend fun getNewsByKeyword(
        @Query("q") keyword: String,
        @Query("page") pageNumber: Long,
        @Query("language") language: String = "en"
    ): Resource<NewsListModel>

    @Headers(AUTH_HEADER)
    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("page") pageNumber: Long,
        @Query("language") language: String = "en"
    ): Resource<NewsListModel>
}