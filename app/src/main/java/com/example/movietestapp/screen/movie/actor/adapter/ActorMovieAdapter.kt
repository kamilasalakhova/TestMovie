package com.example.movietestapp.screen.movie.actor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.databinding.ItemPopularMovieBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.main.tabs.popular.adapter.PopularViewHolder

class ActorMovieAdapter(var onClick: OnItemClickListener): RecyclerView.Adapter<PopularViewHolder>() {
    var itemList = listOf<MovieInList>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = ItemPopularMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(itemList[position])
        holder.itemView.setOnClickListener {
            onClick.onClick(itemList[position])
        }
    }

    override fun getItemCount(): Int = itemList.size
}