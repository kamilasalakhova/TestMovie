package com.example.movietestapp.screen.movie.detail.adapter.holder

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movietestapp.R
import com.example.movietestapp.databinding.ItemTitleListBinding
import com.example.movietestapp.screen.base.listeners.OnActorItemClickListener
import com.example.movietestapp.screen.movie.detail.adapter.MovieCastAdapter
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailActorsItems
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailItems

class MovieDetailActorViewHolder(var binding: ItemTitleListBinding, onClick: OnActorItemClickListener): MovieDetailBaseViewHolder<MovieDetailItems>(binding.root) {
    var adapter = MovieCastAdapter(onClick)

    override fun bind(item: MovieDetailItems) {
        binding.title.text = binding.root.context.resources.getString(R.string.cast)
        binding.list.layoutManager = LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        binding.list.adapter = adapter
        val actors = item as MovieDetailActorsItems
        adapter.itemList = actors.list ?: listOf()
    }
}