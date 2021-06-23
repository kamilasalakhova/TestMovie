package com.example.movietestapp.data.remote.movie

import com.example.movietestapp.data.remote.data.BaseDataSource
import com.example.movietestapp.data.remote.network.NetworkService
import javax.inject.Inject

class MovieRemoteDataSource @Inject constructor(private val networkService: NetworkService):
    BaseDataSource() {
    suspend fun getMovie(id: Int) = getResult{
        networkService.getMovie(id, "ru-RU", "29e1630044a4fe3ffde12eb5664d6c2e")
    }
    suspend fun getMovieCast(id: Int) = getResult{
        networkService.getMovieCast(id, "ru-RU", "29e1630044a4fe3ffde12eb5664d6c2e")
    }
}
