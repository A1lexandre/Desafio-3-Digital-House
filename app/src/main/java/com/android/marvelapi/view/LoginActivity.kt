package com.android.marvelapi.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.marvelapi.R
import com.android.marvelapi.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            startActivity(Intent(this, ComicsListActivity::class.java))
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

        binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(this@LoginActivity, CreateAccountActivity::class.java))
            overridePendingTransition(R.anim.slide_in_up, R.anim.stay)
        }

    }
}