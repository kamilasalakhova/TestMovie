package com.example.movietestapp.data.remote.network

import com.example.movietestapp.data.models.*
import com.example.movietestapp.data.remote.data.BaseListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NetworkService {

    @GET("/3/movie/upcoming")
    suspend fun getMovieUpcoming(
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): Response<BaseListResponse<MovieInList>>

    @GET("/3/movie/top_rated")
    suspend fun getMovieTopRated(
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): Response<BaseListResponse<MovieInList>>

    @GET("/3/movie/popular")
    suspend fun getMoviePopular(
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
        ): Response<BaseListResponse<MovieInList>>

    @GET("/3/movie/{movie_id}")
    suspend fun getMovie(
        @Path("movie_id") id: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): Response<MovieDetail>
    @GET("/3/movie/{movie_id}/credits")
    suspend fun getMovieCast(
        @Path("movie_id") id: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): Response<MovieCredits>

    @GET("/3/person/{person_id}")
    suspend fun getActor(
        @Path("person_id") id: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): Response<ActorDetail>

    @GET("/3/person/{person_id}/movie_credits")
    suspend fun getActorsMovie(
        @Path("person_id") id: Int,
        @Query("language") language: String,
        @Query("api_key") apiKey: String
    ): Response<ActorCredits>
}