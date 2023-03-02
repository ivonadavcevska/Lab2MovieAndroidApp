package mk.ukim.finki.lab2movieapp.domain.movie.retrofit

import mk.ukim.finki.lab2movieapp.domain.movie.model.CastResponse
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDbApi {

    @GET("movie/popular")
    suspend fun getPopular(): Response<MovieResponse>

    @GET("movie/{id}/credits")
    suspend fun getCastMovieList(@Path("id") id:Int): Response<CastResponse>

}