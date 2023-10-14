package devandroid.zeglan.movies.view.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import devandroid.zeglan.movies.databinding.ResMovieListBinding
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.adapter.MovieAdapter

class MainViewHolder(private val binding: ResMovieListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieListModel) {
                binding.textGenre.text = movie.genre
                val movieAdapter = MovieAdapter(movie.list)
                binding.movieRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
                binding.movieRecyclerView.adapter = movieAdapter
        }

}