package com.example.movietestapp.screen.movie.detail

import androidx.lifecycle.ViewModel
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.repository.movie.MovieDetailRepository
import com.example.movietestapp.screen.movie.detail.adapter.models.MovieDetailUI
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieDetailViewModel
    @Inject constructor(private val repository: MovieDetailRepository): ViewModel() {

    var id: MutableStateFlow<Int?> = MutableStateFlow(null)
    var movieDetail: Flow<Resource<MovieDetailUI?>> = id.flatMapConcat { id ->
        repository.getMovie(id)
    }.map {
        Resource(it.status, MovieDetailUI(it.data), it.message)
    }

    fun addId(newId: Int?) {
        id.value = newId
    }
}