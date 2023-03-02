package mk.ukim.finki.lab2movieapp.domain.movie.retrofit

import mk.ukim.finki.lab2movieapp.domain.movie.RemoteMovieDataSource
import mk.ukim.finki.lab2movieapp.domain.movie.model.CastDetails
import mk.ukim.finki.lab2movieapp.domain.movie.model.CastResponse
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieDetails
import retrofit2.Response

class RetrofitMovieDataSource(private val movieDbApi: MovieDbApi): RemoteMovieDataSource {
    override suspend fun getPopular(): List<MovieDetails> {
        val movieResponse = movieDbApi.getPopular()
        val responseBody = movieResponse.body()
        if(movieResponse.isSuccessful && responseBody!=null){
            return responseBody.results
        }
        throw Exception(movieResponse.message())

    }

    override suspend fun getCastMovieList(id: Int): List<CastDetails> {
        val movieResponse = movieDbApi.getCastMovieList(id)
        val responseBody = movieResponse.body()
        if(movieResponse.isSuccessful && responseBody!=null){
            return responseBody.cast
        }
        throw Exception(movieResponse.message())
    }


}
