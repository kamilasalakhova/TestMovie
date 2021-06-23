package com.example.movietestapp.screen.main.tabs.popular.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movietestapp.base.App
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.data.utils.getFormatDate
import com.example.movietestapp.databinding.ItemPopularMovieBinding

class PopularViewHolder(private val binding: ItemPopularMovieBinding): RecyclerView.ViewHolder(binding.root) {

    fun bind(item: MovieInList?){

        item?.let {
            binding.title.text = it.title
            binding.releaseDate.text = it.releaseDate?.getFormatDate() ?: ""
            binding.popularity.text = "${it.popularity}"
            Glide.with(App.context)
                .load("${App.const.IMAGE_URL}${item.image}")
                .into(binding.image)
        }

    }
}