package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2

class MainActivityProfilPelamar : AppCompatActivity() {

    //menampilkan layout profil pelamar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_pelamar)
        // val value = findViewById<ViewPager2>(R.id.signup_pel_id)
        val extras = intent.extras

    }

//    //ketika button 'masuk sebagai pelamar' di homepage di klik, akan ngarah ke halaman sign in pelamar
//    fun btn_sigin_pel(view: View) {
//        val i = Intent(applicationContext, MainActivity::class.java)
//        startActivity(i)
//    }

    fun textViewStatusSeleksi(view: View) {
        val i = Intent(applicationContext, MainActivityStatusSeleksiPelamar::class.java)
        startActivity(i)
    }

    fun textViewKeluar(view: View) {
        val i = Intent(applicationContext, MainActivityHomepage::class.java)
        startActivity(i)
    }


}