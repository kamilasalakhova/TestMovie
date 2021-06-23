package com.example.movietestapp.screen.movie.actor

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movietestapp.data.repository.movie.MovieActorRepository

class MovieActorViewModelFactory(private val repository: MovieActorRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieActorViewModel(repository) as T
    }
}