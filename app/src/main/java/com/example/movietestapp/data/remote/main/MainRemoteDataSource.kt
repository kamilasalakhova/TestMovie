package com.example.movietestapp.data.remote.main

import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.remote.data.BaseDataSource
import com.example.movietestapp.data.remote.data.BaseListResponse
import com.example.movietestapp.data.remote.network.NetworkService
import javax.inject.Inject

abstract class MainRemoteDataSource: BaseDataSource() {
    abstract suspend fun getMovie(page: Int): Resource<BaseListResponse<MovieInList>>
}

class MainPopularRemoteDataSource @Inject constructor(
    private val networkService: NetworkService
): MainRemoteDataSource() {
    override suspend fun getMovie(page: Int) = getResult { networkService.getMoviePopular(page, "ru-RU", "29e1630044a4fe3ffde12eb5664d6c2e") }
}

class MainTopRatedRemoteDataSource @Inject constructor(
    private val networkService: NetworkService
): MainRemoteDataSource() {
    override suspend fun getMovie(page: Int) = getResult { networkService.getMovieTopRated(page, "ru-RU", "29e1630044a4fe3ffde12eb5664d6c2e") }
}

class MainUpcomingRemoteDataSource @Inject constructor(
    private val networkService: NetworkService
): MainRemoteDataSource() {
    override suspend fun getMovie(page: Int) = getResult { networkService.getMovieUpcoming(page, "ru-RU", "29e1630044a4fe3ffde12eb5664d6c2e") }
}