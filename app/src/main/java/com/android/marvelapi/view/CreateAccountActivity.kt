package com.android.marvelapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ActivityCreateAccountBinding

class CreateAccountActivity : AppCompatActivity() {

    lateinit var binding: ActivityCreateAccountBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCreateAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            startActivity(Intent(this, ComicsListActivity::class.java))
        }

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_down)
    }

    fun goBack(view: View) {
        finish()
    }
}