package com.example.movietestapp.data.repository.main

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.movietestapp.base.App.Companion.const
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.data.models.Resource
import com.example.movietestapp.data.remote.main.MainRemoteDataSource
import retrofit2.HttpException
import java.io.IOException

class MoviesPagingSource<T: MainRemoteDataSource>(private val remoteDataSource: T):
    PagingSource<Int, MovieInList>()  {

    override fun getRefreshKey(state: PagingState<Int, MovieInList>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1) ?:
            state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieInList> {
        val pageIndex = params.key ?: 1

        return try {
            val response = remoteDataSource.getMovie(pageIndex)
            if(response.status == Resource.Status.SUCCESS) {
                val movie = response.data?.results ?: listOf()

                val nextKey = if (movie.isEmpty()) {
                    null
                } else {
                    pageIndex + (params.loadSize / const.NETWORK_PAGE_SIZE)
                }
                LoadResult.Page(
                    movie,
                    if (pageIndex == 1) null else pageIndex,
                    nextKey
                )
            } else {
                LoadResult.Error(Throwable(response.message))
            }
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

}