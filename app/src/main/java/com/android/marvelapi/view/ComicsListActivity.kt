package com.android.marvelapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.android.marvelapi.R
import com.android.marvelapi.viewmodel.ComicsViewModel

class ComicsListActivity : AppCompatActivity() {

    lateinit var viewmodel: ComicsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comics_list)

        viewmodel = ViewModelProvider(this).get(ComicsViewModel::class.java)

        viewmodel.getMarvelComics()

        viewmodel.onResultMarvelComics.observe(this, {
            Log.i("Comics", it.comicData.marvelComics.size.toString())
        })

        viewmodel.onError.observe(this, {
            Log.i("ERRO", it)
        })
    }
}