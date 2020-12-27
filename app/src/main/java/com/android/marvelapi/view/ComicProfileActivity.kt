package com.android.marvelapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.marvelapi.databinding.ActivityComicProfileBinding

class ComicProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityComicProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}