package com.example.movietestapp.screen.movie.actor

import androidx.lifecycle.ViewModel
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.repository.movie.MovieActorRepository
import com.example.movietestapp.screen.movie.actor.adapter.models.ActorDetailUI
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class MovieActorViewModel
    @Inject constructor(private val repository: MovieActorRepository): ViewModel() {

    var id = MutableStateFlow<Int?>(null)
    var actorDetail: Flow<Resource<ActorDetailUI?>> = id.flatMapConcat { id ->
        repository.getActor(id)
    }.map {
        Resource(it.status, ActorDetailUI(it.data), it.message)
    }

    fun addId(newId: Int?) {
        id.value = newId
    }
}