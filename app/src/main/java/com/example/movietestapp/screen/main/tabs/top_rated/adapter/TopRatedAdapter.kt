package com.example.movietestapp.screen.main.tabs.top_rated.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.databinding.ItemTopRatedMovieBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.main.tabs.popular.adapter.MovieDiffCallBack


class TopRatedAdapter(private val onClickListener: OnItemClickListener): PagingDataAdapter<MovieInList, TopRatedViewHolder>(MovieDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedViewHolder {
        val binding = ItemTopRatedMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TopRatedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopRatedViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            onClickListener.onClick(getItem(position))
        }
    }

}