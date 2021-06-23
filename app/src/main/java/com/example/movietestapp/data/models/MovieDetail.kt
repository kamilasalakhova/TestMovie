package com.example.movietestapp.data.models

import com.google.gson.annotations.SerializedName

data class MovieDetail(
    val id: Int?,
    val adult: Boolean?,
    val video: Boolean?,
    @SerializedName("backdrop_path")
    val backdrop: String?,
    val budget: Int?,
    val genres: List<MovieGenre>,
    @SerializedName("original_title")
    val titleOriginal: String?,
    val title: String?,
    val overview: String?,
    val popularity: Float?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("poster_path")
    val posterPath: String?,
    @SerializedName("production_companies")
    val productionCompanies: List<MovieProductionCompanies>?,
    @SerializedName("production_countries")
    val productionCountries: List<MovieProductionCountries>?,
    val revenue: Int?,
    val runtime: Int?,
    val status: String?,
    val tagline: String?,
    @SerializedName("vote_average")
    var voteAverage: Float?,
    @SerializedName("vote_count")
    var voteCount: Float?,
    var cast: List<MovieCast>?
    ) {
    fun getGenre(): String {
        return genres.joinToString(separator = " , ") { it.name ?: "" }
    }
}

data class MovieProductionCompanies(val id: Int?,
                                    val name: String?,
                                    @SerializedName("logo_path")
                                    val logo: String?,
                                    @SerializedName("origin_country")
                                    val originCountry: String?)
data class MovieProductionCountries(val name: String?,
                                    @SerializedName("iso_3166_1")
                                    val logo: String?)
data class MovieGenre(val id: Int?, val name: String?)


