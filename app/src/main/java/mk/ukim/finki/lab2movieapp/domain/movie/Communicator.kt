package mk.ukim.finki.lab2movieapp.domain.movie

interface Communicator {
    fun passData(position: Int, id: Int, overview: String, poster: String, title: String)
}