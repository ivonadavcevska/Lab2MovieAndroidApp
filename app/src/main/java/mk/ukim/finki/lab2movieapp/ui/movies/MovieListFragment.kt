package mk.ukim.finki.lab2movieapp.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.lifecycle.ViewModelProvider
import mk.ukim.finki.lab2movieapp.R
import mk.ukim.finki.lab2movieapp.adapters.MovieAdapter
import mk.ukim.finki.lab2movieapp.databinding.FragmentMovieListBinding
import mk.ukim.finki.lab2movieapp.domain.movie.Communicator
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieDetails


class MovieListFragment : Fragment(R.layout.fragment_movie_list), Communicator {

    private var _binding:FragmentMovieListBinding? = null

    private val binding get() = _binding!!

    private lateinit var moviesViewModel:MoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMovieListBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]

        moviesViewModel.getMovieLiveData().observe(viewLifecycleOwner) {
            var adapter: MovieAdapter = MovieAdapter(it as ArrayList<MovieDetails>, this@MovieListFragment)
            binding.movieList.adapter = adapter
        }

        moviesViewModel.getPopular()


    }

    override fun passData(position: Int, id: Int, overview: String, poster: String, title: String) {
        val bundle = Bundle()
        bundle.putInt("position", position)
        bundle.putInt("movieId", id)
        bundle.putString("movieOverview", overview)
        bundle.putString("moviePoster", poster)
        bundle.putString("movieTitle", title)


        val transaction = this.parentFragmentManager.beginTransaction()
        val fragment2 = MovieDetailsFragment()
        fragment2.arguments = bundle

        transaction.replace(R.id.fragment_container_view_tag, fragment2)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}