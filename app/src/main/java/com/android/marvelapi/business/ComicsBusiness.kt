package com.android.marvelapi.business

import com.android.marvelapi.api.ResponseApi
import com.android.marvelapi.model.MarvelResponse
import com.android.marvelapi.repository.ComicsRepository
import com.android.marvelapi.utils.Constants.Api.LARGE_IMAGE

class ComicsBusiness {

    val repository by lazy {
        ComicsRepository()
    }

    suspend fun getComics(numberOfComics: Int): ResponseApi {
        val response = repository.getComics(numberOfComics)
        return when(response) {
            is ResponseApi.Success -> {
                val comics = response.data as MarvelResponse
                comics.comicData.marvelComics.forEach {
                    it.thumbnail.path = "${it.thumbnail.path}/${LARGE_IMAGE}.${it.thumbnail.extension}"
                }
                ResponseApi.Success(response.data)}
            is ResponseApi.Error -> response
        }
    }
}