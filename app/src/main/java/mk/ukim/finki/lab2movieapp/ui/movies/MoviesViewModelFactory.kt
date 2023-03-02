package mk.ukim.finki.lab2movieapp.ui.movies

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.lab2movieapp.domain.movie.repository.MovieRepository
import mk.ukim.finki.lab2movieapp.domain.movie.retrofit.RetrofitMovieDataSource
import mk.ukim.finki.lab2movieapp.domain.movie.retrofit.MovieDbApiProvider


class MoviesViewModelFactory(private val context: Context): ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(MovieRepository(
                RetrofitMovieDataSource(
                    MovieDbApiProvider
                    .getMovieDbApi())))
    }
}