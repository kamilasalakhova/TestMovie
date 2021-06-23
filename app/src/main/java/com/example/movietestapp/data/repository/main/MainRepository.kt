package com.example.movietestapp.data.repository.main

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.movietestapp.base.App.Companion.const
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.data.remote.main.MainPopularRemoteDataSource
import com.example.movietestapp.data.remote.main.MainTopRatedRemoteDataSource
import com.example.movietestapp.data.remote.main.MainUpcomingRemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remotePopularDataSource: MainPopularRemoteDataSource,
    private val remoteTopRatedDataSource: MainTopRatedRemoteDataSource,
    private val remoteUpcomingDataSource: MainUpcomingRemoteDataSource
){
    private var config = PagingConfig(
        pageSize = const.NETWORK_PAGE_SIZE,
        enablePlaceholders = false
    )
    fun getPopularMovies(): Flow<PagingData<MovieInList>> {
        return Pager(
            config = config,
            pagingSourceFactory = {
                MoviesPagingSource(remotePopularDataSource)
            }
        ).flow
    }

    fun getTopMovies(): Flow<PagingData<MovieInList>> {
        return Pager(
            config = config,
            pagingSourceFactory = {
                MoviesPagingSource(remoteTopRatedDataSource)
            }
        ).flow
    }

    fun getUpcomingMovies(): Flow<PagingData<MovieInList>> {
        return Pager(
            config = config,
            pagingSourceFactory = {
                MoviesPagingSource(remoteUpcomingDataSource)
            }
        ).flow
    }
}