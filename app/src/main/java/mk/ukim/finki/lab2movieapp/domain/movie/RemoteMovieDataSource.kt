package mk.ukim.finki.lab2movieapp.domain.movie

import mk.ukim.finki.lab2movieapp.domain.movie.model.CastDetails
import mk.ukim.finki.lab2movieapp.domain.movie.model.CastResponse
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieDetails
import retrofit2.Response

interface RemoteMovieDataSource {
    suspend fun getPopular(): List<MovieDetails>

    suspend fun getCastMovieList(id: Int): List<CastDetails>
}