package com.example.movietestapp.screen.base.listeners

import com.example.movietestapp.data.models.MovieInList

interface OnItemClickListener {
    fun onClick(movie: MovieInList?)
}