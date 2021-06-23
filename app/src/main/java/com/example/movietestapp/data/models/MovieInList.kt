package com.example.movietestapp.data.models

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movies")
data class MovieInList (
    @SerializedName("poster_path")
    var image: String?,
    @SerializedName("overview")
    var description: String?,
    @SerializedName("release_date")
    var releaseDate: String?,
    @SerializedName("genre_ids")
    var genreIds: List<Int>?,
    var id: Int?,
    var title: String?,
    @SerializedName("backdrop_path")
    var backdrond: String?,
    var popularity: Float?,
    @SerializedName("vote_average")
    var voteAverage: Float?
    ){
    fun getMovieStars(): Float{
        return (voteAverage ?: 0f) / 2f
    }
}
