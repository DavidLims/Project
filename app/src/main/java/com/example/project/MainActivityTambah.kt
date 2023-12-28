package com.example.project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.project.databinding.ActivityMainTambahBinding

class MainActivityTambah : AppCompatActivity() {

    private lateinit var binding: ActivityMainTambahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainTambahBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main_tambah)
        setContentView(binding.root)

        binding.fab.setOnClickListener{
            val intent = Intent(this, MainActivityTambahLowongan::class.java)
            startActivity(intent)
        }
    }
}