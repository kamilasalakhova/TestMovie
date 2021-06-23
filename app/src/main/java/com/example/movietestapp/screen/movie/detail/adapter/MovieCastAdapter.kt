package com.example.movietestapp.screen.movie.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietestapp.data.models.MovieCast
import com.example.movietestapp.databinding.ItemMovieActorBinding
import com.example.movietestapp.screen.base.listeners.OnActorItemClickListener
import com.example.movietestapp.screen.movie.detail.adapter.holder.MovieCastViewHolder

class MovieCastAdapter(var onClick: OnActorItemClickListener): RecyclerView.Adapter<MovieCastViewHolder>() {
    var itemList = listOf<MovieCast>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCastViewHolder {
        val binding = ItemMovieActorBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return MovieCastViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieCastViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
            onClick.onClick(itemList[position])
        }
    }

    override fun getItemCount(): Int = itemList.size
}