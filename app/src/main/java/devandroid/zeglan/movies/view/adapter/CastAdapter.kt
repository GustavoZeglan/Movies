package devandroid.zeglan.movies.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import devandroid.zeglan.movies.databinding.ResPersonBinding
import devandroid.zeglan.movies.server.model.CreditsModel
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.view.viewholder.CastViewHolder

class CastAdapter : Adapter<CastViewHolder>() {

    private var cast: List<CreditsModel.People> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val inflate = LayoutInflater.from(parent.context)
        val binding =  ResPersonBinding.inflate(inflate)
        return CastViewHolder(parent.context,binding)
    }

    override fun getItemCount(): Int {
        return cast.size
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.bindPerson(cast[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(list: List<CreditsModel.People>) {
        cast = list
        notifyDataSetChanged()
    }

}