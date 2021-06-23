package com.example.movietestapp.screen.base.listeners

import com.example.movietestapp.data.models.MovieCast

interface OnActorItemClickListener {
    fun onClick(movie: MovieCast?)
}