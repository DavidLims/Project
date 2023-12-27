package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.project.databinding.ActivitySigupPerusahaanBinding
import com.example.project.userPelamar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivitySigupPerusahaan : AppCompatActivity() {

    private lateinit var binding: ActivitySigupPerusahaanBinding
    private lateinit var ref: DatabaseReference

    //menampilkan layout sign up perusahaan
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigupPerusahaanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // val value = findViewById<ViewPager2>(R.id.signup_pel_id)
        val extras = intent.extras

        ref = FirebaseDatabase.getInstance().getReference("userPerusahaan")
        binding.btnregisper.setOnClickListener {
            val userId = ref.push().key
            val username = binding.inputNamaPerusahaan.text.toString()
            val email = binding.inputEmailPerusahaan.text.toString()
            val password = binding.inputPassPerusahaan.text.toString()
            val konfirmasiPass = binding.inputKonfPassPerusahaan.text.toString()
            val userperusahaan = userPerusahaan(userId!!, username, email, password)

            if (username.isNotEmpty() && email.isNotEmpty() && password.isNotEmpty() && konfirmasiPass.isNotEmpty()) {
                if (password == konfirmasiPass) {
                    ref.child(userId).setValue(userperusahaan).addOnCompleteListener {
                        Toast.makeText(
                            applicationContext,
                            "Registrasi berhasil",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        val intent = Intent(this, MainActivitySiginPerusahaan::class.java)
                        startActivity(intent)
                    }
                } else {
                    Toast.makeText(this, "Password tidak cocok!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Field tidak boleh kosong", Toast.LENGTH_SHORT).show()
            }
        }

    }

//    fun btn_sigin_per(view: View) {
//        val i = Intent(applicationContext, MainActivity::class.java)
//        startActivity(i)
//    }

    //ketika text 'Masuk' di halaman sign up perusahaan di klik, akan ngarah ke halaman sign in perusahaan
    fun btn_masuk_lagi_per(view: View) {
        val i = Intent(applicationContext, MainActivitySiginPerusahaan::class.java)
        startActivity(i)
    }

    //ketika text 'Kembali' di halaman sign up perusahaan di klik, akan ngarah ke halaman sign in perusahaan
    fun btn_kembali_signin_per(view: View) {
        val i = Intent(applicationContext, MainActivitySiginPerusahaan::class.java)
        startActivity(i)
    }

    //ketika button 'Masuk' di halaman sign up perusahaan di klik, akan ngarah ke halaman sign in perusahaan
    fun btn_masuk_login_per(view: View) {
        val i = Intent(applicationContext, MainActivitySiginPerusahaan::class.java)
        startActivity(i)
    }
}