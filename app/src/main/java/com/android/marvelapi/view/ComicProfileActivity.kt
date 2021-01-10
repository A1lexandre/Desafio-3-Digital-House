package com.android.marvelapi.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ActivityComicProfileBinding
import com.android.marvelapi.model.MarvelComic
import com.android.marvelapi.utils.Constants.Comic.COMIC
import com.bumptech.glide.Glide
import java.text.DateFormatSymbols
import java.text.SimpleDateFormat
import java.time.LocalDate
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
        comic?.let {
            with(binding) {
                Glide.with(this@ComicProfileActivity).load(it.thumbnail.path).into(imCover)
                tvTitle.text = it.title
                tvDescription.text = it.description
                tvPubDate.text = getDate(it.dates[0].date)
                tvPrice.text = if(it.prices.size > 1) it.prices[1].price else it.prices.first().price
                tvPages.text = if(it.pageCount=="0") "Not specified" else it.pageCount
            }
        }
    }

    private fun getDate(date: String): String {

        val dayOfMonth: List<String> = listOf("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December")
        val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)

        val dat = formatter.parse(date) as Date

        val cal = Calendar.getInstance()

        cal.time = dat

        return "${dayOfMonth.get(cal.get(Calendar.MONTH))}, ${cal.get(Calendar.YEAR)}"
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_down)
    }

    fun goBack(view: View) {
        finish()
    }
}