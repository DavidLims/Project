package com.example.project

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.project.databinding.ActivitySiginPelamarBinding
import com.example.project.SessionManager
import com.google.firebase.database.*

class MainActivitySiginPelamar : AppCompatActivity() {

//    private lateinit var binding: ActivitySiginPelamarBinding galih
//    private lateinit var ref: DatabaseReference galih
    //private lateinit var sessionManager: SessionManager galih

    //menampilkan layout sign in pelamar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivitySiginPelamarBinding.inflate(layoutInflater) galih
        setContentView(R.layout.activity_sigin_pelamar)
        //setContentView(binding.root) galih
        val extras = intent.extras

//        ref = FirebaseDatabase.getInstance().getReference("user") galih
     //   sessionManager = SessionManager(this) galih

//        binding.btnSiginPelId.setOnClickListener { galih
//            val email = binding.emailPel.text.toString()
//            val password = binding.passPel.text.toString()
//            if (email.isNotEmpty() && password.isNotEmpty()) {
//                loginUser(email, password)
//            } else {
//                Toast.makeText(this, "Field tidak boleh kosong", Toast.LENGTH_SHORT).show()
//            }
//            binding.TextViewToRegisPel.setOnClickListener {
//                navigateToRegister()
//            }
//        } galih
    }

//    private fun loginUser(email: String, password: String) { galih
//        val query = ref.orderByChild("email").equalTo(email)
//
//        query.addListenerForSingleValueEvent(object : ValueEventListener {
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    for (userSnapshot in dataSnapshot.children) {
//                        val storedPassword = userSnapshot.child("password").value.toString()
//                        if (password == storedPassword) {
//                            // Password sesuai, login berhasil
//                            val userId = userSnapshot.key
//                            val username = userSnapshot.child("username").value.toString()
//                            //sessionManager.saveUserSession(userId!!, email, username)
//                            navigateToMain()
//                        } else {
//                            showToast("Password salah")
//                        }
//                    }
//                } else {
//                    showToast("Pengguna dengan email $email tidak ditemukan")
//                }
//            }
//
//            override fun onCancelled(databaseError: DatabaseError) {
//                // Implementation for onCancelled method
//            }
//        })
//    } galih




    //ketika button 'masuk' di halaman sign in pelamar di klik, akan ngarah ke halaman beranda pelamar
    fun btn_masuk_pel(view: View) {
        val i = Intent(applicationContext, MainActivityBerandaPelamar::class.java)
        startActivity(i)
    }

    //ketika text 'Daftar' di halaman sign in pelamar di klik, akan ngarah ke halaman sign up pelamar
    fun btn_regis_pel(view: View) {
        val i = Intent(applicationContext, MainActivitySigupPelamar::class.java)
        startActivity(i)
    }

//
//    fun btn_regis_pel(view: View) {
//        val i = Intent(this, MainActivitySigupPelamar::class.java)
//        startActivityForResult(i, 1)
//    }

    //ketika text 'Kembali' di halaman sign in pelamar di klik, akan ngarah ke halaman homepage
    fun btn_kembali_homepage_pel(view: View) {
        val i = Intent(applicationContext, MainActivityHomepage::class.java)
        startActivity(i)
    }

//    private fun navigateToRegister() { galih
//        val intent = Intent(this, MainActivitySigupPelamar::class.java)
//        startActivity(intent)
//    }
//
//    private fun navigateToMain() {z
 //   val intent = Intent(this, MainActivityBerandaPelamar::class.java)
//        startActivity(intent)
//        finish()
//    }
//
//    private fun showToast(message: String) {
//        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
//    } galih
    
}