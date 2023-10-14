package devandroid.zeglan.movies.server.repository.remote

import android.content.Context
import devandroid.zeglan.movies.server.listener.APIListener
import devandroid.zeglan.movies.server.model.GenreListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GenreRepository(val context: Context) : BaseRepository(){

    private val remote = RetrofitClient.getService(GenreService::class.java)

    fun getAllGenres(listener: APIListener<GenreListModel>) {
        val call = remote.getGenres()

        call.enqueue( object : Callback<GenreListModel> {
            override fun onResponse(
                call: Call<GenreListModel>,
                response: Response<GenreListModel>,
            ) {
               handleResponse(response, listener)
            }

            override fun onFailure(call: Call<GenreListModel>, t: Throwable) {
                listener.onFailure("Ocorreu um erro inesperado")
            }

        })

    }

}