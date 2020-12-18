package com.android.marvelapi.business

import com.android.marvelapi.api.ResponseApi
import com.android.marvelapi.repository.ComicsRepository

class ComicsBusiness {

    val repository by lazy {
        ComicsRepository()
    }

    suspend fun getComics(numberOfComics: Int): ResponseApi {
        val response = repository.getComics(numberOfComics)
        return when(response) {
            is ResponseApi.Success -> ResponseApi.Success(response.data)
            is ResponseApi.Error -> response
        }
    }
}