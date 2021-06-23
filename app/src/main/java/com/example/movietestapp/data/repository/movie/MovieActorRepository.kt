package com.example.movietestapp.data.repository.movie

import com.example.movietestapp.data.models.ActorDetail
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.remote.movie.MovieActorRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieActorRepository
@Inject constructor(private val movieRemoteDataSource: MovieActorRemoteDataSource) {

    suspend fun getActor(id: Int?): Flow<Resource<ActorDetail?>> =
        flow{
            if(id != null) {
                emit(Resource.loading<ActorDetail?>())
                val movieResponse = movieRemoteDataSource.getActor(id)
                val castResponse = movieRemoteDataSource.getActorsMovie(id)
                if (movieResponse.status == Resource.Status.SUCCESS && castResponse.status == Resource.Status.SUCCESS) {
                    movieResponse.data?.cast = castResponse.data?.cast
                    emit(Resource.success(movieResponse.data))
                } else {
                    emit(Resource.error<ActorDetail?>("${movieResponse.message ?: ""} ${castResponse.message ?: ""}"))
                }
            } else {
                emit(Resource.error<ActorDetail?>("id = null"))
            }
        }
}