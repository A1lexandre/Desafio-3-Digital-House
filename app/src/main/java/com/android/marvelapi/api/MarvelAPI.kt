package com.android.marvelapi.api

import com.android.marvelapi.model.MarvelResponse
import com.android.marvelapi.utils.Constants.Api.MARVEL_PUBLIC_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    @GET("comics")
    suspend fun getComics(
        @Query("limit") numberOfComics: Int,
        @Query("series") series: Int,
        @Query("orderBy") orderBy: String,
        @Query("hasDigitalIssue") digitalIssue: Boolean
    ): Response<MarvelResponse>
}