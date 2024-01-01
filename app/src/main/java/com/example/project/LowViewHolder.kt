package com.example.project

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.table.Lowongan
class LowViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){

    val cardView: CardView = itemView.findViewById(R.id.cardViewLowPelamar)
    val imageViewLow: ImageView = itemView.findViewById(R.id.imageViewLowPelamar)
    val textViewNamaIntansiBeranda: TextView = itemView.findViewById(R.id.textViewNamaInstansiLow)
    val textViewNamaPosisiBeranda: TextView = itemView.findViewById(R.id.textViewNamaPosisiLow)
    val textViewStatusBeranda: TextView = itemView.findViewById(R.id.textViewNamaStatusLow)
    val textViewJumlahLowBeranda: TextView = itemView.findViewById(R.id.textViewJumlahLow)
    val textViewDurasiBeranda: TextView = itemView.findViewById(R.id.textViewDurasiLow)

    fun bind(lowongan: Lowongan, onItemClickListener: LowAdapter.OnItemClickListener) {
        itemView.setOnClickListener {
            onItemClickListener.onItemClick(lowongan)
        }

        // Populate other views
        // ...
    }
}