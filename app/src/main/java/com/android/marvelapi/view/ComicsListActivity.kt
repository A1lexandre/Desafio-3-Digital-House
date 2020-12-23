package com.android.marvelapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ActivityComicsListBinding
import com.android.marvelapi.view.adapter.ComicListAdapter
import com.android.marvelapi.viewmodel.ComicsViewModel

class ComicsListActivity : AppCompatActivity() {

    lateinit var viewmodel: ComicsViewModel
    lateinit var binding: ActivityComicsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicsListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewmodel = ViewModelProvider(this).get(ComicsViewModel::class.java)

        viewmodel.getMarvelComics()

        viewmodel.onResultMarvelComics.observe(this, {
            binding.rvComicList.apply {
                layoutManager = GridLayoutManager(this@ComicsListActivity, 3)
                adapter = ComicListAdapter(it.comicData.marvelComics)
            }
        })

        viewmodel.onError.observe(this, {
            Log.i("ERRO", it)
        })
    }
}