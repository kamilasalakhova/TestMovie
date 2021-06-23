package com.example.movietestapp.screen.movie.actor.adapter.models

import com.example.movietestapp.R
import com.example.movietestapp.data.models.ActorDetail
import com.example.movietestapp.data.models.MovieInList
import com.example.movietestapp.data.utils.getFormatDate

abstract class ActorDetailItems(open val type: ActorDetailItemsType)

data class ActorDetailDescItems(
    val text: String?,
    override val type: ActorDetailItemsType = ActorDetailItemsType.BIO
): ActorDetailItems(type)

data class ActorDetailMovieItems(
    val list: List<MovieInList>?,
    override val type: ActorDetailItemsType = ActorDetailItemsType.MOVIE
): ActorDetailItems(type)

data class ActorDetailInfoItems(
    val title: Int?,
    var data: String?,
    override val type: ActorDetailItemsType = ActorDetailItemsType.INFO
): ActorDetailItems(type)

enum class ActorDetailItemsType(var type: Int){
    BIO(0), MOVIE(1), INFO(2)
}

class ActorDetailUI(){
    var image: String? = null
    var name: String? = null
    var birthday: String? = null
    var details: MutableList<ActorDetailItems>? = null

    constructor(actor: ActorDetail?): this(){
        image = actor?.profilePath
        name = actor?.name
        birthday = actor?.birthday?.getFormatDate()
        details = mutableListOf()
        details!!.add(ActorDetailDescItems(actor?.biography))
        details!!.add(ActorDetailInfoItems(R.string.place_of_birth, actor?.placeOfBirth))
        details!!.add(ActorDetailInfoItems(R.string.known_for_department, actor?.knownForDepartment))
        details!!.add(ActorDetailInfoItems(R.string.popularity, actor?.popularity?.toString()))
        details!!.add(ActorDetailMovieItems(actor?.cast))
    }
}