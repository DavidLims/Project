package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2

class MainActivitySearchPelamar : AppCompatActivity() {

    //menampilkan layout search pelamar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_pelamar)
        // val value = findViewById<ViewPager2>(R.id.signup_pel_id)
        val extras = intent.extras

    }

//    fun btn_sigin_pel(view: View) {
//        val i = Intent(applicationContext, MainActivity::class.java)
//        startActivity(i)
//    }
}