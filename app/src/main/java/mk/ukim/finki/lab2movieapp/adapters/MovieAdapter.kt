package mk.ukim.finki.lab2movieapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import mk.ukim.finki.lab2movieapp.R
import mk.ukim.finki.lab2movieapp.domain.movie.Communicator
import mk.ukim.finki.lab2movieapp.domain.movie.model.MovieDetails

class MovieAdapter(private val movies:ArrayList<MovieDetails> = ArrayList<MovieDetails>(),
                   private val listener: Communicator): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
        private var image: ImageView = view.findViewById(R.id.movie_image)
        private var titleText: TextView = view.findViewById(R.id.movie_title)
        private var idText: TextView = view.findViewById(R.id.movie_id)

        fun bind(movie: MovieDetails){
            Glide.with(image).load("https://image.tmdb.org/t/p/w185${movie.posterPath}")
                .centerCrop().placeholder(R.drawable.ic_movie).into(image)

            titleText.text = movie.title

            idText.text = movie.id.toString()
        }

        init {
            itemView.setOnClickListener (this)
        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            val movieId = movies[position].id
            val movieTitle = movies[position].title
            val movieOverview = movies[position].overview
            val moviePoster = movies[position].posterPath
            listener.passData(position, movieId, movieOverview, moviePoster, movieTitle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_movie_items, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun updateMovies(movies: List<MovieDetails>){
        this.movies.clear()
        if(movies!=null){
            this.movies.addAll(movies)
        }
        notifyDataSetChanged()
    }
}