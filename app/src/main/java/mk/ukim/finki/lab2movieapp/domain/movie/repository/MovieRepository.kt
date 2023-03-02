package mk.ukim.finki.lab2movieapp.domain.movie.repository

import mk.ukim.finki.lab2movieapp.domain.movie.RemoteMovieDataSource
import mk.ukim.finki.lab2movieapp.domain.movie.model.CastDetails
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieDetails

class MovieRepository(private val remoteMovieDataSource: RemoteMovieDataSource) {

    suspend fun getPopularMovies(): List<MovieDetails> {
        return remoteMovieDataSource.getPopular()
    }

    suspend fun getCastMovieList(id: Int): List<CastDetails> {
        return remoteMovieDataSource.getCastMovieList(id)
    }


}