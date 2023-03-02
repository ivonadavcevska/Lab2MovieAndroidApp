package mk.ukim.finki.lab2movieapp.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import mk.ukim.finki.lab2movieapp.R
import mk.ukim.finki.lab2movieapp.adapters.CastAdapter
import mk.ukim.finki.lab2movieapp.databinding.FragmentMovieDetailsBinding


class MovieDetailsFragment : Fragment(R.layout.fragment_movie_details) {

    private var _binding: FragmentMovieDetailsBinding? = null

    private val binding get() = _binding!!

    private lateinit var moviesViewModel: MoviesViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMovieDetailsBinding.bind(view)

        val viewModelFactory = MoviesViewModelFactory(requireContext())
        moviesViewModel = ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]

        var movieId: Int = arguments?.getInt("movieId")!!
        var movieTitle: String = arguments?.getString("movieTitle").toString()
        var moviePoster: String = arguments?.getString("moviePoster").toString()
        var movieOverview: String = arguments?.getString("movieOverview").toString()

        binding.movieId.text = movieId.toString()
        binding.movieTitle.text = movieTitle
        binding.movieOverview.text = movieOverview
        Glide.with(binding.movieImage).load("https://image.tmdb.org/t/p/w185${moviePoster}")
            .centerCrop().placeholder(R.drawable.ic_movie).into(binding.movieImage)

        moviesViewModel.getCastDetails(movieId)

        var adapter2: CastAdapter = CastAdapter()
        binding.castList.adapter = adapter2




    }
}