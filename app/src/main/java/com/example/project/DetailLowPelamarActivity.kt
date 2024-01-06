package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailLowPelamarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_low_pelamar)

        val id_lowongan = intent.getStringExtra("id_lowongan")
        val posisiLow = intent.getStringExtra("posisiLow")
        val durasiLow = intent.getStringExtra("durasiLow")
        val syaratLow = intent.getStringExtra("syaratLow")
        val penjelasanLow = intent.getStringExtra("penjelasanLow")
        val namaInstansi = intent.getStringExtra("namaInstansi")
        val jumlahLow = intent.getStringExtra("jumlahLow")
        val statusLow = intent.getStringExtra("statusLow")
        val imageUrl = intent.getStringExtra("imageUrl")

        findViewById<TextView>(R.id.textViewPosisiDetail).text = posisiLow
        findViewById<TextView>(R.id.textViewDurasiDetail).text = durasiLow
        findViewById<TextView>(R.id.textViewSyaratLowDetail).text = syaratLow
        findViewById<TextView>(R.id.textViewPenjelasanLowDetail).text = penjelasanLow
        findViewById<TextView>(R.id.textViewNamaInstansiDetail).text = namaInstansi
        findViewById<TextView>(R.id.textViewJumlahLowDetail).text = jumlahLow
        findViewById<TextView>(R.id.textViewStatusLowDetail).text = statusLow

        val imageView = findViewById<ImageView>(R.id.imageDetailLow)
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.drawable.low1) // You can set a placeholder image
            .into(imageView)

//        fetchDataFromFirebase(id_lowongan)

    }

    fun btn_kembali_beranda_pel(view: View) {
        val i = Intent(applicationContext, MainActivityBerandaPelamar::class.java)
        startActivity(i)
    }

    fun btn_lamar_kerja(view: View) {
        val i = Intent(applicationContext, ProfilPelamarActivity::class.java)
        startActivity(i)
    }
    //

//    private fun fetchDataFromFirebase(id_lowongan: String?) {
//        val database: FirebaseDatabase = FirebaseDatabase.getInstance()
//        val reference: DatabaseReference = database.reference.child("your_database_node").child("lowongan")
//
//        if (id_lowongan != null) {
//            reference.child(id_lowongan).addListenerForSingleValueEvent(object : ValueEventListener {
//                override fun onDataChange(dataSnapshot: DataSnapshot) {
//                    // This method is called once with the initial value and again
//                    // whenever data at this location is updated.
//
//                    // Retrieve data based on the Lowongan class
//                    val lowongan: Lowongan? = dataSnapshot.getValue(Lowongan::class.java)
//
//                    // Now you can use the retrieved data
//                    // Update your UI or perform any other actions here
//                    updateUI(lowongan)
//                }
//
//                override fun onCancelled(error: DatabaseError) {
//                    // Failed to read value
//                    Log.w("YourActivity", "Failed to read value.", error.toException())
//                }
//            })
//        }
//    }


//    private fun updateUI(lowongan: Lowongan?) {
//        // Update your UI with the fetched data
//        if (lowongan != null) {
//            findViewById<TextView>(R.id.textViewPosisiDetail).text = lowongan.posisiLow
//            findViewById<TextView>(R.id.textViewDurasiDetail).text = lowongan.durasiLow
//            findViewById<TextView>(R.id.textViewSyaratLowDetail).text = lowongan.syaratLow
//            findViewById<TextView>(R.id.textViewNamaInstansiDetail).text = lowongan.namaInstansi
//            findViewById<TextView>(R.id.textViewJumlahLowDetail).text = lowongan.jumlahLow
//            findViewById<TextView>(R.id.textViewStatusLowDetail).text = lowongan.statusLow
//
//            val imageView = findViewById<ImageView>(R.id.imageDetailLow)
//            Glide.with(this)
//                .load(lowongan.imageUrl)
//                .placeholder(R.drawable.low1) // You can set a placeholder image
//                .into(imageView)
//        }
//    }

}