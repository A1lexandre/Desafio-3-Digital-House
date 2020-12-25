package com.android.marvelapi.repository

import com.android.marvelapi.api.MarvelApiService
import com.android.marvelapi.api.ResponseApi
import com.android.marvelapi.utils.Constants.Api.NUMBER_OF_COMICS

class ComicsRepository {

    suspend fun getComics(numberOfComics: Int): ResponseApi {
        return try {
            val response = MarvelApiService.marvelAPI.getComics(NUMBER_OF_COMICS, 2069, "issueNumber", true, )
//            val response = MarvelApiService.marvelAPI.getComics(NUMBER_OF_COMICS, 2050, "issueNumber")

            if (response.isSuccessful) {
                ResponseApi.Success(response.body())
            } else {
                if (response.code() == 404) {
                    ResponseApi.Error("Dado não encontrado")
                } else {
                    ResponseApi.Error("Erro ao carregar os dados")
                }
            }
        } catch (exception: Exception) {
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }
}