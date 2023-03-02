package mk.ukim.finki.lab2movieapp.domain.movie.model

import com.google.gson.annotations.SerializedName

data class MovieDetails(
    val id: Int,

    val overview: String,

    @SerializedName("poster_path") val posterPath: String,

    val title: String
) {
}