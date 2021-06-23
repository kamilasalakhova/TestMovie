package com.example.movietestapp.screen.main.tabs.upcoming.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.databinding.ItemUpcomingMovieBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.main.tabs.popular.adapter.MovieDiffCallBack

class UpcomingAdapter(private val onClickListener: OnItemClickListener): PagingDataAdapter<MovieInList, UpcomingViewHolder>(MovieDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingViewHolder {
        val binding = ItemUpcomingMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UpcomingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UpcomingViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onClickListener.onClick(getItem(position))
        }
    }
}