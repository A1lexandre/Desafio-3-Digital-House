package com.android.marvelapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.marvelapi.R
import com.bumptech.glide.Glide

class ComicProfilePicActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_profile_pic)

        Glide.with(this).load(intent.getStringExtra("profilePicPath")).into(findViewById(R.id.comicCoverPic))

    }

    fun goBack(view: View) {
        finish()
    }
}