package devandroid.zeglan.movies.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import devandroid.zeglan.movies.databinding.ResMovieListBinding
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.listener.OnMovieListener
import devandroid.zeglan.movies.view.viewholder.MainViewHolder

class MainAdapter : Adapter<MainViewHolder>() {

    var mainList: List<MovieListModel> = arrayListOf()
    private lateinit var listener: OnMovieListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val itemBinding = ResMovieListBinding.inflate(inflate)
        return MainViewHolder(itemBinding, listener)
    }

    override fun getItemCount(): Int {
        return mainList.size
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(mainList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<MovieListModel>) {
        mainList = list
        notifyDataSetChanged()
    }

    fun attachListener(guestListener: OnMovieListener) {
        listener = guestListener
    }


}