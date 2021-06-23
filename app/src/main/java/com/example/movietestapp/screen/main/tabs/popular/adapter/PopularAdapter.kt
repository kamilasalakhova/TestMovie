package com.example.movietestapp.screen.main.tabs.popular.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.databinding.ItemPopularMovieBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener


class PopularAdapter(private val onClickListener: OnItemClickListener): PagingDataAdapter<MovieInList, PopularViewHolder>(MovieDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = ItemPopularMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PopularViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onClickListener.onClick(getItem(position))
        }
    }
}