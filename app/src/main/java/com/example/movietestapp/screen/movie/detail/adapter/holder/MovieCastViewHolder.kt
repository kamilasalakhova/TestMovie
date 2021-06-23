package com.example.movietestapp.screen.movie.detail.adapter.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.movietestapp.R
import com.example.movietestapp.base.App
import com.example.movietestapp.data.models.MovieCast
import com.example.movietestapp.databinding.ItemMovieActorBinding

class MovieCastViewHolder(val binding: ItemMovieActorBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: MovieCast){
        binding.title.text = item.name
        binding.character.text = item.character
        Glide.with(App.context)
            .load("${App.const.IMAGE_URL}${item.profilePath}")
            .apply(
                RequestOptions()
                .override(400, 400)
                .centerInside()
                .placeholder(R.drawable.ic_launcher_foreground))
            .into(binding.image)
    }
}