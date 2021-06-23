package com.example.movietestapp.screen.movie.detail.adapter.holder

import com.example.movietestapp.R
import com.example.movietestapp.databinding.ItemTitileTextBinding
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailInfoItems
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailItems

class MovieDetailInfoViewHolder(var binding: ItemTitileTextBinding): MovieDetailBaseViewHolder<MovieDetailItems>(binding.root) {
    override fun bind(item: MovieDetailItems) {
        val itemInfo = item as MovieDetailInfoItems
        binding.title.text = binding.root.context.getString(itemInfo.title ?: R.string.empty)
        binding.data.text = itemInfo.data
    }
}