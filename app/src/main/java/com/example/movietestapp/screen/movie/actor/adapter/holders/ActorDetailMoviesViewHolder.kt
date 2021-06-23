package com.example.movietestapp.screen.movie.actor.adapter.holders

import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movietestapp.R
import com.example.movietestapp.databinding.ItemTitleListBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.base.utils.NewWidthItemDecoration
import com.example.movietestapp.screen.movie.actor.adapter.ActorMovieAdapter
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailItems
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailMovieItems

class ActorDetailMoviesViewHolder(var binding: ItemTitleListBinding, onClick: OnItemClickListener) :
    ActorDetailBaseViewHolder<ActorDetailItems>(binding.root) {
    var adapter = ActorMovieAdapter(onClick)

    override fun bind(item: ActorDetailItems) {
        binding.title.text = binding.root.context.resources.getString(R.string.cast)
        binding.list.layoutManager =
            LinearLayoutManager(binding.root.context, LinearLayoutManager.HORIZONTAL, false)
        binding.list.addItemDecoration(
            NewWidthItemDecoration(
                binding.root.context,
                R.dimen.activity_item_width
            )
        )
        binding.list.adapter = adapter
        val actors = item as ActorDetailMovieItems
        adapter.itemList = actors.list ?: listOf()
    }
}