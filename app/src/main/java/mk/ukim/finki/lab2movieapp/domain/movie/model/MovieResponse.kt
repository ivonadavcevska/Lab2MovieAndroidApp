package mk.ukim.finki.lab2movieapp.domain.movie.model

data class MovieResponse ( val page: Int, val results: List<MovieDetails>) {
}