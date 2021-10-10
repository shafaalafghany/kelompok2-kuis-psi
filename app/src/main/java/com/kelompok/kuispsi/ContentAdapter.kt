package com.kelompok.kuispsi

import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class ContentAdapter (private val list: ArrayList<ContentResponse>): RecyclerView.Adapter<ContentAdapter.ContentViewHolder>(){
    inner class ContentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(contentResponse: ContentResponse){
            with(itemView){
                val name = findViewById<TextView>(R.id.name)
                val genres = findViewById<TextView>(R.id.genre)
                val desc = findViewById<TextView>(R.id.description)
                val poster = findViewById<ImageView>(R.id.poster)
                name.text = "${contentResponse.film_name}"
                genres.text = "${contentResponse.film_genres}"
                desc.text = "${contentResponse.film_desc}"
                Glide.with(poster).load("${contentResponse.film_poster}").into(poster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.film_list, parent, false)
        return ContentViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}