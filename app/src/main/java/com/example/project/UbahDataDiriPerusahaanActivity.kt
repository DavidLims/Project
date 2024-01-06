package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class UbahDataDiriPerusahaanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubah_data_diri_perusahaan)
    }
    fun btnKembaliUbahDataDiriPerusahaan(view: View) {
        val i = Intent(applicationContext, ProfilPerusahaanActivity::class.java)
        startActivity(i)
    }


}