package com.android.marvelapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ActivityComicProfilePicBinding
import com.bumptech.glide.Glide

class ComicProfilePicActivity : AppCompatActivity() {

    private lateinit var binding: ActivityComicProfilePicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicProfilePicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(this).load(intent.getStringExtra("profilePicPath")).into(findViewById(R.id.comicCoverPic))

    }

    fun goBack(view: View) {
        finish()
    }
}