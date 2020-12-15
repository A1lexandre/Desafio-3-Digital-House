package com.android.marvelapi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.marvelapi.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreateAccount.setOnClickListener {
//            val bottomSheet = CreateAccountFragment()
//            bottomSheet.show(supportFragmentManager, null)
            startActivity(Intent(this@LoginActivity, CreateAccountActivity::class.java))
            overridePendingTransition(R.anim.slide_in_up, R.anim.stay)
        }

    }
}