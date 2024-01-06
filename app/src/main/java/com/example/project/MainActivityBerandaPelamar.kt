package com.example.project

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.databinding.ActivityBerandaPelamarBinding
import com.example.project.table.Lowongan
import com.example.project.SessionManagerPel
import com.example.project.SessionManagerPer
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class MainActivityBerandaPelamar : AppCompatActivity() {

    private lateinit var lowAdapter: LowAdapter
    private val lowList: MutableList<Lowongan> = ArrayList()
    private lateinit var searchEditText: EditText

    private lateinit var binding: ActivityBerandaPelamarBinding
    private lateinit var sessionManagerPel: SessionManagerPel
    private lateinit var sessionManagerPer: SessionManagerPer

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBerandaPelamarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //  setContentView(R.layout.activity_add_low)

        sessionManagerPel = SessionManagerPel(this)
        sessionManagerPer = SessionManagerPer(this)
//
//        val image = sess
//        image?.let {
//            Glide.with(applicationContext)
//                .load(it)
//                .placeholder(R.drawable.low1) // placeholder image while loading
//                .error(R.drawable.kita) // error image if loading fails
//                .into(binding.cartImageView)
//        }


        val recyclerView: RecyclerView = binding.recyclerViewPel
        recyclerView.layoutManager = GridLayoutManager(applicationContext, 1)

        lowAdapter = LowAdapter(lowList, object : LowAdapter.OnItemClickListener {
            override fun onItemClick(lowongan: Lowongan) {
                // Handle item click, for example, navigate to detail activity
                val intent = Intent(applicationContext, DetailLowPelamarActivity::class.java)
                intent.putExtra("id_lowongan", lowongan.id_lowongan)
                intent.putExtra("posisiLow", lowongan.posisiLow)
                intent.putExtra("durasiLow", lowongan.durasiLow)
                intent.putExtra("statusLow", lowongan.statusLow)
                intent.putExtra("syaratLow", lowongan.syaratLow)
                intent.putExtra("penjelasanLow", lowongan.penjelasanLow)
                intent.putExtra("namaInstansi", lowongan.namaInstansi)
                intent.putExtra("jumlahLow", lowongan.jumlahLow)
                intent.putExtra("imageUrl", lowongan.imageUrl)
                startActivity(intent)
            }
        })
        recyclerView.adapter = lowAdapter

        fetchDataFromFirebase()

        binding.bottomNavigationViewPel.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home ->
                {
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                    // Ganti dengan Intent untuk Activity yang Anda inginkan
                    val intent = Intent(this, MainActivityBerandaPelamar::class.java)
                    startActivity(intent)
                }
//                    replaceFragment(HomeFragment())
                R.id.tentang ->
                    //replaceFragment(AddFragment())
                {
//                    replaceFragment(TentangPelamarFragment())
//                     Ganti dengan Intent untuk Activity yang Anda inginkan
                    val intent = Intent(this, TentangPelamarActivity::class.java)
                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                }
                R.id.profile ->
                {
//                    replaceFragment(ProfilPelamarFragment())
                    val intent = Intent(this, ProfilPelamarActivity::class.java)
                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

                }
//                    replaceFragment(ProfileFragment())

            }
            true
        }

        val editTextSearch: EditText = binding.EditTextSearch

        editTextSearch.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                performSearch(editTextSearch.text.toString())
                return@setOnEditorActionListener true
            }
            false
        }

    }

//    private fun filterLowongann(query: String) {
//        val filteredList = lowList.filter { lowongan ->
//            lowongan.posisiLow.toLowerCase().contains(query.toLowerCase())
//        }
//        lowAdapter = LowAdapter(filteredList)
//        recyclerViewPel.adapter = lowAdapter
//    }

    private fun performSearch(query: String) {
        Log.d("SearchDebug", "Performing search with query: $query")
        lowAdapter.filter(query)
    }

//        val sidebarMenuImageView: ImageView = binding.imageViewSidebarMenu
//        sidebarMenuImageView.setOnClickListener {
//            binding.drawerLayout.openDrawer(GravityCompat.START)
//        }
//
//    fun replaceFragment(fragment: Fragment) {
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.fragmentContainer, fragment)
//        transaction.addToBackStack(null)
//        transaction.commit()
//    }

    fun fetchDataFromFirebase() {
        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("lowongann")

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                lowList.clear()

                for (productSnapshot in snapshot.children) {
                    val lowongan = productSnapshot.getValue(Lowongan::class.java)
                    lowongan?.let { lowList.add(it) }
                }

                // Refresh tampilan RecyclerView dengan adapter
                lowAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
            }
        })
    }

//
//                if (sessionManagerPel.isLoggedInPel()) {
//            replaceFragment(BerandaPelamarFragment())
//        } else {
//            //Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@MainActivity, "Gagal login", Toast.LENGTH_SHORT).show()
//        }

//        if (sessionManagerPer.isLoggedInPer()) {
//            val i = Intent(applicationContext, MainActivityBerandaPerusahaan::class.java)
//            startActivity(i)
//        } else {
//            //Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@MainActivity, "Anda belum melakukan registrasi", Toast.LENGTH_SHORT).show()
//        }


    fun displayLowongann(lowongann: List<Lowongan>) {
        // Mengupdate data produk dalam adapter
//        lowAdapter.updateData(lowongann)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    //ketika button 'masuk sebagai pelamar' di homepage di klik, akan ngarah ke halaman beranda pelamar
    fun btn_masuk_pel(view: View) {
        val i = Intent(applicationContext, MainActivityBerandaPelamar::class.java)
        startActivity(i)
    }

    //ketika button 'Lihat Detail' di beranda pelamar di klik, akan ngarah ke halaman detail lowongan
    fun btn_lihat_detail_pel_1(view: View) {
        val i = Intent(applicationContext, DetailLowPelamarActivity::class.java)
        startActivity(i)
    }



}