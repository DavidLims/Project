package com.example.project

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.table.Lowongan

//class untuk menampilkan yang disimpan di firebase

class LowAdapter(
    private val lowList: List<Lowongan>,
    private val onItemClickListener: OnItemClickListener
)  : RecyclerView.Adapter<LowViewHolder>() {

    // Interface to handle item clicks
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
        holder.textViewNamaIntansiBeranda.text = lowongan.namaInstansi
        holder.textViewNamaPosisiBeranda.text = lowongan.posisiLow
        //holder.textViewStatusBeranda.text = lowongan.statusLow
        holder.textViewDurasiBeranda.text = lowongan.durasiLow
        holder.textViewJumlahLowBeranda.text = lowongan.jumlahLow

        lowongan.imageUrl?.let {
            Glide.with(holder.itemView.context)
                .load(it)
                .placeholder(R.drawable.low2)
                .into(holder.imageViewLow)
        }
        holder.textViewStatusBeranda.text = lowongan.statusLow

        holder.bind(lowongan, onItemClickListener)
    }
    override fun getItemCount(): Int {
        return lowList.size
    }
}


