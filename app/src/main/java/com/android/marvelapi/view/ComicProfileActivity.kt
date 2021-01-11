package com.android.marvelapi.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ActivityComicProfileBinding
import com.android.marvelapi.model.MarvelComic
import com.android.marvelapi.utils.Constants.Comic.COMIC
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*

class ComicProfileActivity : AppCompatActivity() {
    lateinit var binding: ActivityComicProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityComicProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val comic = intent.getParcelableExtra<MarvelComic>(COMIC)
        Log.i("Comic", comic.toString())
        setupComicInformation(comic)

    }

    private fun setupComicInformation(comic: MarvelComic?) {
        comic?.let { marvelComic ->
            with(binding) {
                Glide.with(this@ComicProfileActivity).load(marvelComic.thumbnail.path).into(imCover)
                imCover.setOnClickListener { _ ->
                    val intent = Intent(this@ComicProfileActivity, ComicProfilePicActivity::class.java)
                    intent.putExtra("profilePicPath", marvelComic.thumbnail.path)
                    val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@ComicProfileActivity, imCover, ViewCompat.getTransitionName(imCover) ?: "")
                    startActivity(intent, options.toBundle())
                }
                tvTitle.text = marvelComic.title
                tvDescription.text = marvelComic.description
                tvPubDate.text = getDate(marvelComic.dates[0].date)
                tvPrice.text = if(marvelComic.prices.size > 1) marvelComic.prices[1].price else marvelComic.prices.first().price
                tvPages.text = if(marvelComic.pageCount=="0") "Not specified" else marvelComic.pageCount
            }
        }
    }

    private fun getDate(date: String): String {

        val dayOfMonth: List<String> = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)

        val dat = formatter.parse(date) as Date

        val cal = Calendar.getInstance()

        cal.time = dat

        return "${dayOfMonth[cal.get(Calendar.MONTH)]}, ${cal.get(Calendar.YEAR)}"
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_down)
    }

    fun goBack(view: View) {
        finish()
    }
}