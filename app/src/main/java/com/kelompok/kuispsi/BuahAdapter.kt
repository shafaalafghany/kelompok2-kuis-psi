package com.kelompok.kuispsi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView

/*
* class adapter untuk menghandle data yang akan ditampilkan pada recyclerview
* jumlah properti pada data harus disesuaikan pada method onBindViewHolder
* */
class BuahAdapter(private var itemsList: List<String>) :
    RecyclerView.Adapter<BuahAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var itemTextView: TextView = view.findViewById(R.id.itemTextView)
    }

    // fungsi inisialisasi awal untuk menyiapkan layout yang akan digunakan
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    // Mengaitkan data sesuai dengan indeksnya
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = itemsList[position]
        holder.itemTextView.text = item
    }

    // mengembalikan jumlah data dari dataset
    override fun getItemCount(): Int {
        return itemsList.size
    }
}