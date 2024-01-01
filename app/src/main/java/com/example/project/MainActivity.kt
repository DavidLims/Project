package com.example.project

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.project.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sessionManagerPel: SessionManagerPel
    private lateinit var sessionManagerPer: SessionManagerPer


    //menampilkan tampilan utama layout homepage
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  setContentView(R.layout.activity_add_low)

        sessionManagerPel = SessionManagerPel(this)
        sessionManagerPer = SessionManagerPer(this)


        if (sessionManagerPel.isLoggedInPel()) {
            replaceFragment(BerandaPelamarFragment())
        } else {
            //Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
            Toast.makeText(this@MainActivity, "Gagal login", Toast.LENGTH_SHORT).show()
        }

//        if (sessionManagerPer.isLoggedInPer()) {
//            val i = Intent(applicationContext, MainActivityBerandaPerusahaan::class.java)
//            startActivity(i)
//        } else {
//            //Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@MainActivity, "Anda belum melakukan registrasi", Toast.LENGTH_SHORT).show()
//        }

        binding.bottomNavigationViewPel.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
//                R.id.home -> replaceFragment(BerandaPelamarFragment())
//                R.id.tentang -> replaceFragment(TentangPelamarFragment())
//                R.id.profile -> replaceFragment(ProfilPelamarFragment())
                R.id.home -> replaceFragment(BerandaPelamarFragment())
                R.id.tentang -> replaceFragment(TentangPelamarFragment())
                R.id.profile -> replaceFragment(ProfilPelamarFragment())
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        //val fragmentManager = supportFragmentManager
        ///val fragmentTransaction = fragmentManager.beginTransaction()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}