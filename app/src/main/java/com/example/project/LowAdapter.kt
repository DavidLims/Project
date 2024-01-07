package com.example.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.table.Lowongan

//class untuk menampilkan yang disimpan di firebase

class LowAdapter(
    private var lowList: MutableList<Lowongan> = mutableListOf(),
    private val onItemClickListener: OnItemClickListener
)  : RecyclerView.Adapter<LowViewHolder>() {

//    private var filteredList: List<Lowongan> = lowList.toMutableList()
//    fun updateData(newData: List<Lowongan>) {
//        lowList.clear()
//        lowList.addAll(newData)
//        notifyDataSetChanged()
//
//    }

//    fun filter(query: String) {
//        filteredList = if (query.isEmpty()) {
//            productList
//        } else {
//            productList.filter { it.productName?.contains(query, ignoreCase = true) == true }
//        }.toMutableList()
//        notifyDataSetChanged()
//    }

    // Interface to handle item clicks

//    fun filter(query: String) {
//        filteredList = if (query.isEmpty()) {
//            lowList.toMutableList()
//        } else {
//            lowList.filter {
//                it.posisiLow?.toLowerCase()?.contains(query.toLowerCase()) == true}
//        }.toMutableList()
//        notifyDataSetChanged()
//
//        Log.d("FilterDebug", "Query: $query, Filtered list: $filteredList")
//    }


    interface OnItemClickListener {
        fun onItemClick(lowongan: Lowongan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.low_card_layout_pelamar, parent, false)
        return LowViewHolder(view)
    }

    override fun onBindViewHolder(holder: LowViewHolder, position: Int) {
        val lowongan = lowList[position]
        lowongan.imageUrl?.let {
            Glide.with(holder.itemView.context)
                .load(it)
                .placeholder(R.drawable.low2)
                .into(holder.imageViewLow)
        }
        holder.textViewNamaPosisiBeranda.text = lowongan.posisiLow
        holder.textViewDurasiBeranda.text = lowongan.durasiLow
        holder.textViewStatusBeranda.text = lowongan.statusLow
        holder.textViewNamaIntansiBeranda.text = lowongan.namaInstansi
        holder.textViewJumlahLowBeranda.text = lowongan.jumlahLow

        holder.bind(lowongan, onItemClickListener)
    }
    override fun getItemCount(): Int {
        return lowList.size
    }

    fun searchLowonganList(searchList: List<Lowongan>){
        lowList = searchList.toMutableList()
        notifyDataSetChanged()
    }
}


