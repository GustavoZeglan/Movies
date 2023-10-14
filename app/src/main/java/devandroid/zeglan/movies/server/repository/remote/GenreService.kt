package devandroid.zeglan.movies.server.repository.remote

import devandroid.zeglan.movies.server.model.GenreListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreService {

    @GET("genre/movie/list")
    fun getGenres(@Query("language") language: String = "pt-br") : Call<GenreListModel>

}