package devandroid.zeglan.movies.view.viewholder

import android.content.Context
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import devandroid.zeglan.movies.databinding.ResPersonBinding
import devandroid.zeglan.movies.server.model.CreditsModel

class CastViewHolder(val context: Context, val binding: ResPersonBinding) : ViewHolder(binding.root) {

    fun bindPerson(person: CreditsModel.People) {


        Glide.with(context).load("https://image.tmdb.org/t/p/w342${person.image}").into(binding.imagePerson)
        binding.txtName.text = person.name

        binding.personShimmer.stopShimmer()
    }

}