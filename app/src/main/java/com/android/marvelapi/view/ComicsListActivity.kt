package com.android.marvelapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ActivityComicsListBinding
import com.android.marvelapi.utils.Constants.Comic.COMIC
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
            binding.loadingView.root.visibility = View.GONE
            binding.rvComicList.apply {
                layoutManager = GridLayoutManager(this@ComicsListActivity, 3)
                adapter = ComicListAdapter(it.comicData.marvelComics) {
                    val intent = Intent(this@ComicsListActivity, ComicProfileActivity::class.java)
                    intent.putExtra(COMIC, it)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_in_up, R.anim.stay)
                }
            }
        })

        viewmodel.onError.observe(this, {
            Log.i("ERRO", it)
        })
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}