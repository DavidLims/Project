package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.get
import androidx.viewpager2.widget.ViewPager2
import com.example.project.databinding.ActivitySigupPelamarBinding
import com.example.project.userPelamar
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivitySigupPelamar : AppCompatActivity() {

    private lateinit var binding: ActivitySigupPelamarBinding
    private lateinit var ref: DatabaseReference


    //menampilkan layout sign up pelamar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigupPelamarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // val value = findViewById<ViewPager2>(R.id.signup_pel_id)
        val extras = intent.extras

        ref = FirebaseDatabase.getInstance().getReference("userPelamar")
        binding.btnregispel.setOnClickListener {
            val userId = ref.push().key
            val email = binding.inputEmailPelamar.text.toString()
            val username = binding.inputNamaPelamar.text.toString()
            val password = binding.inputPassPelamar.text.toString()
            val konfirmasiPass = binding.inputKonfPassPelamar.text.toString()
            val noHp = binding.inputHpPelamar.toString()
            val userpelamar = userPelamar(userId!!, email, username, password, noHp)

            if (email.isNotEmpty() && username.isNotEmpty() && password.isNotEmpty() && konfirmasiPass.isNotEmpty() && noHp.isNotEmpty()) {
                if (password == konfirmasiPass) {
                    ref.child(userId).setValue(userpelamar).addOnCompleteListener {
                        Toast.makeText(
                            applicationContext,
                            "Registrasi berhasil",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                        val intent = Intent(this, MainActivitySiginPelamar::class.java)
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




        //ketika text 'Masuk' di halaman sign up pelamar di klik, akan ngarah ke halaman sign in pelamar
        fun btn_masuk_lagi_pel(view: View) {
            val i = Intent(applicationContext, MainActivitySiginPelamar::class.java)
            startActivity(i)
        }

        //ketika text 'Kembali' di halaman sign up pelamar di klik, akan ngarah ke halaman sign in pelamar
        fun btn_kembali_signin_pel(view: View) {
            val i = Intent(applicationContext, MainActivitySiginPelamar::class.java)
            startActivity(i)
        }

        //ketika button 'Daftr' di halaman sign up pelamar di klik, akan ngarah ke halaman sign in pelamar
        fun btn_masuk_login_pel(view: View) {
            val i = Intent(applicationContext, MainActivitySiginPelamar::class.java)
            startActivity(i)
        }

    }
