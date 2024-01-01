package com.example.project

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailLowPelamarActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_low_pelamar)

        val id_lowongan = intent.getStringExtra("id_lowongan")
        val posisiLow = intent.getStringExtra("posisiLow")
        val durasiLow = intent.getStringExtra("durasiLow")
        val syaratLow = intent.getStringExtra("syaratLow")
        val namaInstansi = intent.getStringExtra("namaInstansi")
        val jumlahLow = intent.getStringExtra("jumlahLow")
        val statusLow = intent.getStringExtra("statusLow")
        val imageUrl = intent.getStringExtra("imageUrl")

        findViewById<TextView>(R.id.textViewPosisiDetail).text = posisiLow
        findViewById<TextView>(R.id.textViewDurasiDetail).text = durasiLow
        findViewById<TextView>(R.id.textViewSyaratLowDetail).text = syaratLow
        findViewById<TextView>(R.id.textViewNamaInstansiDetail).text = namaInstansi
        findViewById<TextView>(R.id.textViewJumlahLowDetail).text = jumlahLow
        findViewById<TextView>(R.id.textViewStatusLowDetail).text = statusLow

        val imageView = findViewById<ImageView>(R.id.imageDetailLow)
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.low1) // You can set a placeholder image
            .into(imageView)

       // fetchDataFromFirebase(id_lowongan)

    }

//    private fun fetchDataFromFirebase(id_lowongan: String?) {
//        // Check if productId is not null before using it
//        id_lowongan?.let { nonNullId_Lowongan ->
//            val databaseReference: DatabaseReference =
//                FirebaseDatabase.getInstance().getReference("lowongann/$nonNullId_Lowongan")
//
//            databaseReference.addValueEventListener(object : ValueEventListener {
//                override fun onDataChange(snapshot: DataSnapshot) {
//                    // Get the product category from the snapshot
//                    val  = snapshot.child("productCategory").getValue(String::class.java)
//
//                    // Fetch related products based on the category
//                    productCategory?.let {
//                        fetchRelatedProducts(it)
//                    }
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    // Handle error
//                }
//            })
//        }
//    }


}