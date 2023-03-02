package mk.ukim.finki.lab2movieapp.ui.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import mk.ukim.finki.lab2movieapp.domain.movie.model.CastDetails
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieDetails
import mk.ukim.finki.lab2movieapp.domain.movie.repository.MovieRepository

class MoviesViewModel(private val movieRepository: MovieRepository): ViewModel() {

    private val moviesLiveData = MutableLiveData<List<MovieDetails>>()

    private val castLiveData = MutableLiveData<List<CastDetails>>()

    fun getMovieLiveData(): LiveData<List<MovieDetails>> = moviesLiveData

    fun getCastMovieDetails(): LiveData<List<CastDetails>> = castLiveData

    fun getPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.getPopularMovies()
            moviesLiveData.postValue(movies)
        }
    }

    fun getCastDetails(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val cast = movieRepository.getCastMovieList(id)
            castLiveData.postValue(cast)
        }
    }



}