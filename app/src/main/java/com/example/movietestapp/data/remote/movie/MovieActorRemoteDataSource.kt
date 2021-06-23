package com.example.movietestapp.data.remote.movie

import com.example.movietestapp.data.remote.data.BaseDataSource
import com.example.movietestapp.data.remote.network.NetworkService
import javax.inject.Inject

class MovieActorRemoteDataSource @Inject constructor(private val networkService: NetworkService):
    BaseDataSource() {
    suspend fun getActor(id: Int) = getResult{
        networkService.getActor(id, "ru-RU", "29e1630044a4fe3ffde12eb5664d6c2e")
    }
    suspend fun getActorsMovie(id: Int) = getResult{
        networkService.getActorsMovie(id, "ru-RU", "29e1630044a4fe3ffde12eb5664d6c2e")
    }
}
