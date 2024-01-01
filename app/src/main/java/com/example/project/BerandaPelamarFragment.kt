package com.example.project

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.project.table.Lowongan
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class BerandaPelamarFragment : Fragment() {
    private lateinit var lowAdapter: LowAdapter
    private val lowList: MutableList<Lowongan> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_beranda_pelamar, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewLow)
        recyclerView.layoutManager = GridLayoutManager(context, 1)

        // Inisialisasi adapter
        lowAdapter = LowAdapter(lowList, object : LowAdapter.OnItemClickListener {
            override fun onItemClick(lowongan: Lowongan) {
                // Handle item click, for example, navigate to detail activity
                val intent = Intent(context, DetailLowPelamarActivity::class.java)
               // intent.putExtra("productId", product.productId)
                intent.putExtra("posisiLow", lowongan.posisiLow)
                intent.putExtra("durasiLow", lowongan.durasiLow)
                intent.putExtra("namaInstansi", lowongan.namaInstansi)
                intent.putExtra("jumlahLow", lowongan.jumlahLow)
                intent.putExtra("statusLow", lowongan.statusLow)
                intent.putExtra("imageUrl", lowongan.imageUrl)
                startActivity(intent)
            }
        })
        recyclerView.adapter = lowAdapter

        fetchDataFromFirebase()

        return view
    }

    private fun fetchDataFromFirebase() {
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
}


