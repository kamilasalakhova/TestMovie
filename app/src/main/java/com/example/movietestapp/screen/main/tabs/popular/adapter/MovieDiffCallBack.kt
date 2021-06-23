package com.example.movietestapp.screen.main.tabs.popular.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.movietestapp.data.models.MovieInList

class MovieDiffCallBack : DiffUtil.ItemCallback<MovieInList>() {
    override fun areItemsTheSame(oldItem: MovieInList, newItem: MovieInList): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MovieInList, newItem: MovieInList): Boolean {
        return oldItem == newItem
    }
}