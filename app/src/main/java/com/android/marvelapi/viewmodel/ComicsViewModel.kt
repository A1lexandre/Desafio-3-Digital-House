package com.android.marvelapi.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.marvelapi.api.ResponseApi
import com.android.marvelapi.business.ComicsBusiness
import com.android.marvelapi.model.MarvelResponse
import com.android.marvelapi.utils.Constants.Api.NUMBER_OF_COMICS
import kotlinx.coroutines.launch

class ComicsViewModel: ViewModel() {

   val onResultMarvelComics: MutableLiveData<MarvelResponse> = MutableLiveData()
    val onError: MutableLiveData<String> = MutableLiveData()

    val business by lazy {
        ComicsBusiness()
    }

    fun getMarvelComics() {
        viewModelScope.launch {
            when(val response = business.getComics(NUMBER_OF_COMICS)) {
                is ResponseApi.Success -> onResultMarvelComics.postValue(
                    response.data as MarvelResponse
                )
                is ResponseApi.Error -> onError.postValue(
                    response.message
                )
            }
        }
    }
}