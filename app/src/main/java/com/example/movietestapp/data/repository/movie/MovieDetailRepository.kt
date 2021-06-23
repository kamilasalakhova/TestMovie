package com.example.movietestapp.data.repository.movie

import com.example.movietestapp.data.models.MovieDetail
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.remote.movie.MovieRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieDetailRepository
@Inject constructor(private val movieRemoteDataSource: MovieRemoteDataSource) {

    fun getMovie(id: Int?): Flow<Resource<MovieDetail?>> =
        flow{
            if(id != null) {
                emit(Resource.loading<MovieDetail?>())
                val movieResponse = movieRemoteDataSource.getMovie(id)
                val castResponse = movieRemoteDataSource.getMovieCast(id)
                if (movieResponse.status == Resource.Status.SUCCESS && castResponse.status == Resource.Status.SUCCESS) {
                    movieResponse.data?.cast = castResponse.data?.cast
                    emit(Resource.success(movieResponse.data))
                } else {
                    emit(Resource.error<MovieDetail?>("${movieResponse.message ?: ""} ${castResponse.message ?: ""}"))
                }
            }
        }
}

