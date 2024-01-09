package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.project.databinding.ActivityProfilPerusahaanBinding
class ProfilPerusahaanActivity : AppCompatActivity() {

    //    private lateinit var profileAdapter: ProfileAdapter
    private lateinit var binding: ActivityProfilPerusahaanBinding
//    private lateinit var sessionManagerPer: SessionManagerPer

    //    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilPerusahaanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sessionManagerPer = SessionManagerPer(applicationContext)

        val usernamePer = sessionManagerPer.getUserNamePer()
        val image = sessionManagerPer.getUserImageUrlPer()

        binding.textViewNamaInstansiProfilPer.text = usernamePer

        image?.let {
            Glide.with(this)
                .load(it)
                .placeholder(R.drawable.ic_upload) // placeholder image while loading
                .error(R.drawable.ic_upload) // error image if loading fails
                .into(binding.LogoPerProfil)
        }

        binding.bottomNavigationViewPerProfil.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    // Ganti dengan Intent untuk Activity yang Anda inginkan
                    val intent = Intent(this, MainActivityBerandaPerusahaan::class.java)
                    startActivity(intent)
                }
//                    replaceFragment(HomeFragment())
                R.id.add ->
                    //replaceFragment(AddFragment())
                {
//                    replaceFragment(TentangPelamarFragment())
//                     Ganti dengan Intent untuk Activity yang Anda inginkan
                    val intent = Intent(this, ActivityAddLow::class.java)
                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                }

                R.id.profile -> {
//                    replaceFragment(ProfilPelamarFragment())
                    val intent = Intent(this, ProfilPerusahaanActivity::class.java)
                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                }
//                    replaceFragment(ProfileFragment())

            }
            true
        }
    }

    fun textViewKeluarPer(view: View) {
        val i = Intent(applicationContext, MainActivityHomepage::class.java)
        startActivity(i)
    }

    fun textViewLihatDataDiriPer(view: View) {
        val i = Intent(applicationContext, DataProfilePerusahaanActivity::class.java)
        startActivity(i)
    }



}