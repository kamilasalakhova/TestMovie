package com.example.movietestapp.screen.movie.actor.adapter.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ActorDetailBaseViewHolder<in T>(view: View): RecyclerView.ViewHolder(view){
    abstract fun bind(item: T)
}