package devandroid.zeglan.movies.view.viewholder

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import devandroid.zeglan.movies.databinding.ResMovieListBinding
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.adapter.MovieAdapter
import devandroid.zeglan.movies.view.listener.OnMovieListener

class MainViewHolder(private val binding: ResMovieListBinding, private val listener: OnMovieListener)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieListModel) {
                binding.textGenre.text = movie.genre
                val movieAdapter = MovieAdapter(movie.list, listener)
                binding.movieRecyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL,false)
                binding.movieRecyclerView.adapter = movieAdapter
        }

}