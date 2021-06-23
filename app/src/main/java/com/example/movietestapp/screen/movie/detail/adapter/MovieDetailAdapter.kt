package com.example.movietestapp.screen.movie.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movietestapp.databinding.ItemTextBinding
import com.example.movietestapp.databinding.ItemTitileTextBinding
import com.example.movietestapp.databinding.ItemTitleListBinding
import com.example.movietestapp.screen.base.listeners.OnActorItemClickListener
import com.example.movietestapp.screen.movie.detail.adapter.holder.MovieDetailActorViewHolder
import com.example.movietestapp.screen.movie.detail.adapter.holder.MovieDetailBaseViewHolder
import com.example.movietestapp.screen.movie.detail.adapter.holder.MovieDetailDescriptionViewHolder
import com.example.movietestapp.screen.movie.detail.adapter.holder.MovieDetailInfoViewHolder
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailItems
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailItemsType

class MovieDetailAdapter(var onClick: OnActorItemClickListener): RecyclerView.Adapter<MovieDetailBaseViewHolder<MovieDetailItems>>() {
    var itemList = listOf<MovieDetailItems>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieDetailBaseViewHolder<MovieDetailItems>{
        return when(viewType){
            MovieDetailItemsType.DESC.type -> {
                val binding = ItemTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MovieDetailDescriptionViewHolder(binding)
            }
            MovieDetailItemsType.ACTORS.type -> {
                val binding = ItemTitleListBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MovieDetailActorViewHolder(binding, onClick)
            }
            else -> {
                val binding = ItemTitileTextBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
                MovieDetailInfoViewHolder(binding)
            }
        }

    }

    override fun onBindViewHolder(holder: MovieDetailBaseViewHolder<MovieDetailItems>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemViewType(position: Int): Int {
        return itemList[position].type.type
    }
}