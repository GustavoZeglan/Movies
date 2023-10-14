package devandroid.zeglan.movies.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import devandroid.zeglan.movies.databinding.ResMovieBinding
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.listener.OnMovieListener
import devandroid.zeglan.movies.view.viewholder.MovieViewHolder

class MovieAdapter(var movieData: List<MovieListModel.MovieModel>, var _listener: OnMovieListener) : Adapter<MovieViewHolder>() {

    private var movieList: List<MovieListModel.MovieModel> = arrayListOf()
    private lateinit var listener: OnMovieListener

    init {
        this.movieList = movieData
        this.listener = _listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val inflate = LayoutInflater.from(parent.context)
        val itemBinding = ResMovieBinding.inflate(inflate)
        return MovieViewHolder(parent.context,itemBinding, listener)
    }

    override fun getItemCount(): Int = movieList.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bindData(movieList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateMovies(list: List<MovieListModel.MovieModel>) {
        movieList = list
        notifyDataSetChanged()
    }

}