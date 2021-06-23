package com.example.movietestapp.di.module

import com.example.movietestapp.data.repository.main.MainRepository
import com.example.movietestapp.data.repository.movie.MovieActorRepository
import com.example.movietestapp.data.repository.movie.MovieDetailRepository
import com.example.movietestapp.screen.main.MainViewModelFactory
import com.example.movietestapp.screen.movie.actor.MovieActorViewModelFactory
import com.example.movietestapp.screen.movie.detail.MovieDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelFactoryModule {
    @Provides
    fun createMainViewModelFactory(repository: MainRepository): MainViewModelFactory {
        return MainViewModelFactory(repository)
    }

    @Provides
    fun createMovieDetailViewModelFactory(repository: MovieDetailRepository): MovieDetailViewModelFactory {
        return MovieDetailViewModelFactory(repository)
    }

    @Provides
    fun createMovieActorViewModelFactory(repository: MovieActorRepository): MovieActorViewModelFactory {
        return MovieActorViewModelFactory(repository)
    }
}