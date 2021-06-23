package com.example.movietestapp.di

import android.content.Context
import com.example.movietestapp.di.module.AppModule
import com.example.movietestapp.di.module.NetworkModule
import com.example.movietestapp.di.module.RepositoryModel
import com.example.movietestapp.di.module.ViewModelFactoryModule
import com.example.movietestapp.screen.main.MainActivity
import com.example.movietestapp.screen.main.MainViewModelFactory
import com.example.movietestapp.screen.main.tabs.popular.PopularFragment
import com.example.movietestapp.screen.movie.actor.MovieActorViewModelFactory
import com.example.movietestapp.screen.movie.detail.MovieDetailViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, ViewModelFactoryModule::class, NetworkModule::class, RepositoryModel::class])
interface AppComponent {
    fun context(): Context
    fun networkComponent(): NetworkComponent
    fun mainViewModelFactory(): MainViewModelFactory
    fun movieDetailViewModelFactory(): MovieDetailViewModelFactory
    fun movieActorViewModelFactory(): MovieActorViewModelFactory
    fun inject(activity: MainActivity)
    fun inject(fragment: PopularFragment)

}