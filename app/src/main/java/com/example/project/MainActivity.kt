package com.example.project

import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

//    private lateinit var lowAdapter: LowAdapter
//    private val lowList: MutableList<Lowongan> = ArrayList()
//
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var sessionManagerPel: SessionManagerPel
//    private lateinit var sessionManagerPer: SessionManagerPer
//
//    lateinit var toggle: ActionBarDrawerToggle
//
//    //menampilkan tampilan utama layout homepage
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//        //  setContentView(R.layout.activity_add_low)
//
//        sessionManagerPel = SessionManagerPel(this)
//        sessionManagerPer = SessionManagerPer(this)
//
//        val recyclerView: RecyclerView = binding.recyclerViewLow
//        recyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
//
//        lowAdapter = LowAdapter(lowList, object : LowAdapter.OnItemClickListener {
//            override fun onItemClick(lowongan: Lowongan) {
//                // Handle item click, for example, navigate to detail activity
//                val intent = Intent(applicationContext, DetailLowPelamarActivity::class.java)
//                intent.putExtra("id_lowongan", lowongan.id_lowongan)
//                intent.putExtra("posisiLow", lowongan.posisiLow)
//                intent.putExtra("durasiLow", lowongan.durasiLow)
//                intent.putExtra("statusLow", lowongan.statusLow)
//                intent.putExtra("syaratLow", lowongan.syaratLow)
//                intent.putExtra("penjelasanLow", lowongan.penjelasanLow)
//                intent.putExtra("namaInstansi", lowongan.namaInstansi)
//                intent.putExtra("jumlahLow", lowongan.jumlahLow)
//                intent.putExtra("imageUrl", lowongan.imageUrl)
//                startActivity(intent)
//            }
//        })
//        recyclerView.adapter = lowAdapter
//
//        fetchDataFromFirebase()
//
//        binding.bottomNavigationViewPel.setOnNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.home ->
//                {
//                    // Ganti dengan Intent untuk Activity yang Anda inginkan
//                    val intent = Intent(this, ::class.java)
//                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//                }
////                    replaceFragment(HomeFragment())
//                R.id.menu_add ->
//                    //replaceFragment(AddFragment())
//                {
//                    // Ganti dengan Intent untuk Activity yang Anda inginkan
//                    val intent = Intent(this, AddProductActivity::class.java)
//                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//                }
//                R.id.menu_profile ->
//                {
//                    val intent = Intent(this, ProfileActivity::class.java)
//                    startActivity(intent)
//                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
//
//                }
////                    replaceFragment(ProfileFragment())
//
//            }
//            true
//        }
//
//    }
////        val sidebarMenuImageView: ImageView = binding.imageViewSidebarMenu
////        sidebarMenuImageView.setOnClickListener {
////            binding.drawerLayout.openDrawer(GravityCompat.START)
////        }
//
//         fun fetchDataFromFirebase() {
//            val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("lowongann")
//
//            databaseReference.addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    lowList.clear()
//
//                    for (productSnapshot in snapshot.children) {
//                        val lowongan = productSnapshot.getValue(Lowongan::class.java)
//                        lowongan?.let { lowList.add(it) }
//                    }
//
//                    // Refresh tampilan RecyclerView dengan adapter
//                    lowAdapter.notifyDataSetChanged()
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    // Handle error
//                }
//            })
//         }
//
////
////                if (sessionManagerPel.isLoggedInPel()) {
////            replaceFragment(BerandaPelamarFragment())
////        } else {
////            //Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
////            Toast.makeText(this@MainActivity, "Gagal login", Toast.LENGTH_SHORT).show()
////        }
//
////        if (sessionManagerPer.isLoggedInPer()) {
////            val i = Intent(applicationContext, MainActivityBerandaPerusahaan::class.java)
////            startActivity(i)
////        } else {
////            //Toast.makeText(this@MainActivityTambahLowongan, "Tidak ada gambar yang dipilih", Toast.LENGTH_SHORT).show()
////            Toast.makeText(this@MainActivity, "Anda belum melakukan registrasi", Toast.LENGTH_SHORT).show()
////        }
//
//
//        fun displayLowongann(lowongann: List<Lowongan>) {
//            // Mengupdate data produk dalam adapter
//            lowAdapter.updateData(lowongann)
//        }
//
//        override fun onOptionsItemSelected(item: MenuItem): Boolean {
//            if (toggle.onOptionsItemSelected(item)) {
//                return true
//            }
//            return super.onOptionsItemSelected(item)
//        }
}