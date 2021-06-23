package com.example.movietestapp.screen.movie.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.movietestapp.data.repository.movie.MovieDetailRepository

class MovieDetailViewModelFactory(private val repository: MovieDetailRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(repository) as T
    }
}