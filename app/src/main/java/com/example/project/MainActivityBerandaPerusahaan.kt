package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2

class MainActivityBerandaPerusahaan : AppCompatActivity() {

    //menampilkan layout beranda perusahaan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_perusahaan)
        // val value = findViewById<ViewPager2>(R.id.signup_pel_id)
        val extras = intent.extras

    }

    //ketika button 'masuk sebagai perusahaan' di homepage di klik, akan ngarah ke halaman beranda perusahaan
    fun btn_masuk_per(view: View) {
        val i = Intent(applicationContext, MainActivityBerandaPerusahaan::class.java)
        startActivity(i)
    }
}