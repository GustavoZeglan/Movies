package devandroid.zeglan.movies.view.viewholder

import android.content.Context
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import devandroid.zeglan.movies.databinding.ResMovieBinding
import devandroid.zeglan.movies.server.model.MovieListModel

class MovieViewHolder(private val context: Context,private val binding: ResMovieBinding) : ViewHolder(binding.root) {

    fun bindData(movie: MovieListModel.MovieModel) {
        val imageView = binding.imgMovie
//        Glide.with(context).load("https://t4.ftcdn.net/jpg/00/97/58/97/360_F_97589769_t45CqXyzjz0KXwoBZT9PRaWGHRk5hQqQ.jpg").into(imageView)
        Glide.with(context).load("https://image.tmdb.org/t/p/w342${movie.poster_path}").into(imageView)

        imageView.setOnClickListener(){
            Toast.makeText(context, movie.title, Toast.LENGTH_LONG).show()
        }

    }

}
