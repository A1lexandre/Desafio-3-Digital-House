package com.android.marvelapi.api

import com.android.marvelapi.model.MarvelResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    @GET("comics")
    suspend fun getComics(
        @Query("limit") numberOfComics: Int
    ): Response<MarvelResponse>
}