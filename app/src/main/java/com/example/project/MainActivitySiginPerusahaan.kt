package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivitySiginPerusahaan : AppCompatActivity() {

    //menampilkan layout sign in perusahaan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sigin_perusahaan)
        val extras = intent.extras

    }

//    fun btn_sigin_per(view: View) {
//        val i = Intent(applicationContext, MainActivityBerandaPelamar::class.java)
//        startActivity(i)
//    }

    //ketika button 'masuk' di halaman sign in perusahaan di klik, akan ngarah ke halaman beranda perusahaan
    fun btn_masuk_per(view: View) {
        val i = Intent(applicationContext, MainActivityBerandaPerusahaan::class.java)
        startActivity(i)
    }

    //ketika text 'Daftar' di halaman sign in perusahaan di klik, akan ngarah ke halaman sign up perusahaan
    fun btn_regis_per(view: View) {
        val i = Intent(applicationContext, MainActivitySigupPerusahaan::class.java)
        startActivity(i)
    }

    //ketika text 'Kembali' di halaman sign in perusahaan di klik, akan ngarah ke halaman homepage
    fun btn_kembali_homepage_per(view: View) {
        val i = Intent(applicationContext, MainActivityHomepage::class.java)
        startActivity(i)
    }

}