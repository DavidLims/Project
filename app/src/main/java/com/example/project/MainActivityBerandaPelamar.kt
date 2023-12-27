package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.project.databinding.ActivityBerandaPelamarBinding

class MainActivityBerandaPelamar : AppCompatActivity() {

//    private lateinit var binding: ActivityBerandaPelamarBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding =ActivityBerandaPelamarBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        binding.bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//
//            }
//        }
//    }

    //menampilkan layout beranda pelamar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beranda_pelamar)
        // val value = findViewById<ViewPager2>(R.id.signup_pel_id)
        val extras = intent.extras

    }

    //ketika button 'masuk sebagai pelamar' di homepage di klik, akan ngarah ke halaman beranda pelamar
    fun btn_masuk_pel(view: View) {
        val i = Intent(applicationContext, MainActivityBerandaPelamar::class.java)
        startActivity(i)
    }

    //ketika button 'Lihat Detail' di beranda pelamar di klik, akan ngarah ke halaman detail lowongan
    fun btn_lihat_detail_pel_1(view: View) {
        val i = Intent(applicationContext, MainActivityDetailLowBukaPel::class.java)
        startActivity(i)
    }



}