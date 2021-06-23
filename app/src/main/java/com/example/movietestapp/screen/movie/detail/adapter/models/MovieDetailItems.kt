package com.example.movietestapp.screen.movie.detail.adapter.models

import com.example.movietestapp.R
import com.example.movietestapp.data.models.*
import com.example.movietestapp.data.utils.getFormatDate

abstract class MovieDetailItems(open val type: MovieDetailItemsType)

data class MovieDetailDescItems(
    val text: String?,
    override val type: MovieDetailItemsType = MovieDetailItemsType.DESC
): MovieDetailItems(type)

data class MovieDetailActorsItems(
    val list: List<MovieCast>?,
    override val type: MovieDetailItemsType = MovieDetailItemsType.ACTORS
): MovieDetailItems(type)

data class MovieDetailInfoItems(
    val title: Int?,
    var data: String?,
    override val type: MovieDetailItemsType = MovieDetailItemsType.INFO
): MovieDetailItems(type)

enum class MovieDetailItemsType(var type: Int){
    DESC(0), ACTORS(1), INFO(2)
}

class MovieDetailUI(){
    var backdrop: String? = null
    var title: String? = null
    var releaseDate: String? = null
    var details: MutableList<MovieDetailItems>? = null

    constructor(movie: MovieDetail?): this(){
        backdrop = movie?.backdrop
        title = movie?.title
        releaseDate = movie?.releaseDate?.getFormatDate()
        details = mutableListOf()
        details!!.add(MovieDetailDescItems(movie?.overview))
        details!!.add(MovieDetailInfoItems(R.string.tagline, movie?.tagline))
        details!!.add(MovieDetailInfoItems(R.string.genre, movie?.getGenre()))
        details!!.add(MovieDetailInfoItems(R.string.budget, movie?.budget.toString()))
        details!!.add(MovieDetailActorsItems(movie?.cast))
    }
}