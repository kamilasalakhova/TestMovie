package com.example.movietestapp.screen.movie.actor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietestapp.databinding.ItemTextBinding
import com.example.movietestapp.databinding.ItemTitileTextBinding
import com.example.movietestapp.databinding.ItemTitleListBinding
import com.example.movietestapp.screen.base.listeners.OnItemClickListener
import com.example.movietestapp.screen.movie.actor.adapter.holders.ActorDetailBaseViewHolder
import com.example.movietestapp.screen.movie.actor.adapter.holders.ActorDetailBioViewHolder
import com.example.movietestapp.screen.movie.actor.adapter.holders.ActorDetailInfoViewHolder
import com.example.movietestapp.screen.movie.actor.adapter.holders.ActorDetailMoviesViewHolder
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailItems
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailItemsType

class ActorDetailAdapter(val onClick: OnItemClickListener): RecyclerView.Adapter<ActorDetailBaseViewHolder<ActorDetailItems>>() {
    var itemList = listOf<ActorDetailItems>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorDetailBaseViewHolder<ActorDetailItems>{
        return when(viewType){
            ActorDetailItemsType.BIO.type -> {
                val binding = ItemTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ActorDetailBioViewHolder(binding)
            }
            ActorDetailItemsType.MOVIE.type -> {
                val binding = ItemTitleListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ActorDetailMoviesViewHolder(binding, onClick)
            }
            else -> {
                val binding = ItemTitileTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                ActorDetailInfoViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: ActorDetailBaseViewHolder<ActorDetailItems>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type.type
    }
}