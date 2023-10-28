package devandroid.zeglan.movies.view.viewholder

import android.content.Context
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import devandroid.zeglan.movies.databinding.ResDetailedMovieBinding
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.listener.OnMovieListener

class WatchListViewHolder(val binding: ResDetailedMovieBinding, val context:Context, val listener: OnMovieListener) : ViewHolder(binding.root) {

    fun onBind(movie: MovieListModel.MovieModel) {

        binding.cardMovie.setOnClickListener() {
            listener.onClick(movie.id)
        }

        val poster = binding.imgPoster
        Glide.with(context).load("https://image.tmdb.org/t/p/w780${movie.poster_path}").into(poster)

        binding.txtTitle.text = movie.title
    }

}