package com.example.newsapp.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.newsapp.R
import com.example.newsapp.static.Ssylka

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    lateinit var rus : ImageView
    lateinit var usa : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        rus = findViewById(R.id.rus)
        usa = findViewById(R.id.usa)

        rus.setOnClickListener {
            val inten =  Intent(this@SplashActivity, MainActivity::class.java)
            inten.putExtra("country", "ru")
            Ssylka.allUsers = "ru"
            startActivity(inten)
        }


        usa.setOnClickListener {
            val inten =  Intent(this@SplashActivity, MainActivity::class.java)
            Ssylka.allUsers = "us"
            inten.putExtra("country", "us")
            startActivity(inten)
        }

    }
}