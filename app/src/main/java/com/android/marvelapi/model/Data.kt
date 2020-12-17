package com.android.marvelapi.model

data class Data(
        val count: String,
        val limit: String,
        val offset: String,
        val marvelComics: List<MarvelComic>,
        val total: String
)