package com.android.marvelapi.model

import com.google.gson.annotations.SerializedName

data class Data(
        val count: String,
        val limit: String,
        val offset: String,
        @SerializedName("results")
        val marvelComics: List<MarvelComic>,
        val total: String
)