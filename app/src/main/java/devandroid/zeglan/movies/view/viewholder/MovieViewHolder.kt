package devandroid.zeglan.movies.view.viewholder

import android.content.Context
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import devandroid.zeglan.movies.databinding.ResMovieBinding
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.listener.OnMovieListener

class MovieViewHolder(private val context: Context,private val binding: ResMovieBinding, val listener: OnMovieListener)
    : ViewHolder(binding.root) {

    fun bindData(movie: MovieListModel.MovieModel) {
        val imageView = binding.imgMovie
        if(movie.poster_path != "") {
            Glide.with(context).load("https://image.tmdb.org/t/p/w342${movie.poster_path}").into(imageView)
        } else {
            Glide.with(context).load("https://t4.ftcdn.net/jpg/00/97/58/97/360_F_97589769_t45CqXyzjz0KXwoBZT9PRaWGHRk5hQqQ.jpg").into(imageView)
        }

        imageView.setOnClickListener(){

            listener.onClick(movie.id)

        }

        binding.movieShimmer.stopShimmer()

    }

}
