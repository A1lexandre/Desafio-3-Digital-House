package com.android.marvelapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.stay, R.anim.slide_out_down)
    }

    fun goBack(view: View) {
        finish()
    }
}