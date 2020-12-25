package com.android.marvelapi.model

data class MarvelComic(
    val dates: List<Date>,
    val description: String,
    val diamondCode: String,
    val digitalId: String,
    val ean: String,
    val format: String,
    val id: String,
    val images: List<Image>,
    val series: Serie,
    val isbn: String,
    val issn: String,
    val issueNumber: String,
    val modified: String,
    val pageCount: String,
    val prices: List<Price>,
    val thumbnail: Thumbnail,
    val title: String,
    val upc: String,
    val variantDescription: String
)