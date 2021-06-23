package com.example.movietestapp.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.data.repository.main.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MainViewModel @Inject constructor(private val repository: MainRepository):  ViewModel() {

    init {
        getAllMovies()
    }

    var popularPagedList: Flow<PagingData<MovieInList>>? = null
    var topRatedPagedList: Flow<PagingData<MovieInList>>? = null
    var upcomingPagedList: Flow<PagingData<MovieInList>>? = null

    private fun getAllMovies(){
        popularPagedList = repository.getPopularMovies().cachedIn(viewModelScope)
        topRatedPagedList = repository.getTopMovies().cachedIn(viewModelScope)
        upcomingPagedList = repository.getUpcomingMovies().cachedIn(viewModelScope)
    }
}