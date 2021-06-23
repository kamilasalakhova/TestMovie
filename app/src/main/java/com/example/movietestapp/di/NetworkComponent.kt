package com.example.movietestapp.di

import com.example.movietestapp.data.remote.main.MainPopularRemoteDataSource
import com.example.movietestapp.data.remote.main.MainTopRatedRemoteDataSource
import com.example.movietestapp.data.remote.main.MainUpcomingRemoteDataSource
import com.example.movietestapp.data.remote.network.NetworkService
import com.example.movietestapp.data.repository.main.MainRepository
import dagger.Subcomponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@Subcomponent()
interface NetworkComponent {
    fun retrofit(): Retrofit
    fun okHttpClient(): OkHttpClient
    fun networkService(): NetworkService
    fun mainRepository(): MainRepository
    fun mainPopularRemoteDataSource(): MainPopularRemoteDataSource
    fun mainTopRatedRemoteDataSource(): MainTopRatedRemoteDataSource
    fun mainUpcomingRemoteDataSource(): MainUpcomingRemoteDataSource
}