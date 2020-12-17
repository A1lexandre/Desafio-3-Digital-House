package com.android.marvelapi.model

import com.google.gson.annotations.SerializedName

data class MarvelResponse(
    val attributionHTML: String,
    val attributionText: String,
    val code: String,
    val copyright: String,
    @SerializedName("data")
    val comicData: Data,
    val etag: String,
    val status: String
)