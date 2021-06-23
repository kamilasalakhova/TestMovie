package com.example.movietestapp.screen.movie.detail.adapter.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class MovieDetailBaseViewHolder<in T>(view: View): RecyclerView.ViewHolder(view), MovieDetailBaseBind<T>

interface MovieDetailBaseBind<in T>{
    fun bind(item: T)
}