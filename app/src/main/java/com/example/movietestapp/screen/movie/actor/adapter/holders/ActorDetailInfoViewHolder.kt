package com.example.movietestapp.screen.movie.actor.adapter.holders

import com.example.movietestapp.R
import com.example.movietestapp.databinding.ItemTitileTextBinding
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailInfoItems
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailItems

class ActorDetailInfoViewHolder(var binding: ItemTitileTextBinding): ActorDetailBaseViewHolder<ActorDetailItems>(binding.root) {
    override fun bind(item: ActorDetailItems) {
        val itemInfo = item as ActorDetailInfoItems
        binding.title.text = binding.root.context.getString(itemInfo.title ?: R.string.empty)
        binding.data.text = itemInfo.data
    }
}