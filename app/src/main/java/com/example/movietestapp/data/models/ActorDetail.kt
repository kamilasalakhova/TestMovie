package com.example.movietestapp.data.models

import com.google.gson.annotations.SerializedName

class ActorDetail(
    val id: Int?,
    val birthday: String?,
    @SerializedName("known_for_department")
    val knownForDepartment: String?,
    @SerializedName("place_of_birth")
    val placeOfBirth: String?,
    @SerializedName("profile_path")
    val profilePath: String?,
    val name: String?,
    val biography: String?,
    val popularity: Float?,
    var cast: List<MovieInList>?,
)