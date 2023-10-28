package devandroid.zeglan.movies.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import devandroid.zeglan.movies.databinding.ResDetailedMovieBinding
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.listener.OnMovieListener
import devandroid.zeglan.movies.view.viewholder.WatchListViewHolder

class WatchListAdapter : Adapter<WatchListViewHolder>() {

    private var watchlist: List<MovieListModel.MovieModel> = arrayListOf()
    private lateinit var listener: OnMovieListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WatchListViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding = ResDetailedMovieBinding.inflate(inflate)
        return WatchListViewHolder(binding, parent.context, listener)
    }

    override fun getItemCount(): Int {
        return watchlist.size
    }

    override fun onBindViewHolder(holder: WatchListViewHolder, position: Int) {
        holder.onBind(watchlist[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<MovieListModel.MovieModel>){
        watchlist = list
        notifyDataSetChanged()
    }

    fun attachListener(guestListener: OnMovieListener) {
        listener = guestListener
    }

}