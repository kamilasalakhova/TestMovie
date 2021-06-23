package com.example.movietestapp.data.models

import com.google.gson.annotations.SerializedName

class MovieCredits(
    val id: Int?,
    val cast: List<MovieCast>?
)

class MovieCast(
    val adult: Boolean?,
    val id: Int?,
    @SerializedName("profile_path")
    val profilePath: String?,
    val name: String?,
    val character: String?
)