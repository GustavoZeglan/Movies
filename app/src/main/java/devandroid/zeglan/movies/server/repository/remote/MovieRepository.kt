package devandroid.zeglan.movies.server.repository.remote

import android.content.Context
import devandroid.zeglan.movies.server.listener.APIListener
import devandroid.zeglan.movies.server.model.CreditsModel
import devandroid.zeglan.movies.server.model.MovieDetailModel
import devandroid.zeglan.movies.server.model.MovieImages
import devandroid.zeglan.movies.server.model.MovieListModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(val context: Context) : BaseRepository(){

    private val remote = RetrofitClient.getService(MovieService::class.java)

    fun getPopularMovies(listener: APIListener<MovieListModel>){
        val call = remote.getPopularMovies()

        call.enqueue( object : Callback<MovieListModel> {
            override fun onResponse(
                call: Call<MovieListModel>,
                response: Response<MovieListModel>
            ) {
                handleResponse(response, listener)
            }

            override fun onFailure(call: Call<MovieListModel>, t: Throwable) {
                listener.onFailure("Ocorreu um erro inesperado")
            }

        })


    }

    fun getFilteredMovies(genres: String, language: String, page: Int, listener: APIListener<MovieListModel>){
        val call = remote.getFilteredMovies(genres,language, page)

        call.enqueue( object : Callback<MovieListModel> {
            override fun onResponse(
                call: Call<MovieListModel>,
                response: Response<MovieListModel>
            ) {
                handleResponse(response, listener)
            }

            override fun onFailure(call: Call<MovieListModel>, t: Throwable) {
                listener.onFailure("Ocorreu um erro inesperado")
            }

        })


    }

    fun getMovieDetail(movieId: Int, listener: APIListener<MovieDetailModel>) {

        val call = remote.getMovieDetail(movieId)

        call.enqueue( object : Callback<MovieDetailModel> {
            override fun onResponse(
                call: Call<MovieDetailModel>,
                response: Response<MovieDetailModel>,
            ) {
                handleResponse(response,listener)
            }

            override fun onFailure(call: Call<MovieDetailModel>, t: Throwable) {
                listener.onFailure("Ocorreu um erro inesperado.")
            }

        })

    }


    fun getMovieImages(movieId: Int, listener: APIListener<MovieImages>) {

        val call = remote.getMovieImages(movieId)

        call.enqueue( object : Callback<MovieImages> {

            override fun onResponse(call: Call<MovieImages>, response: Response<MovieImages>) {
                handleResponse(response,listener)
            }

            override fun onFailure(call: Call<MovieImages>, t: Throwable) {
                listener.onFailure("Ocorreu um erro inesperado.")
            }

        })

    }

    fun getMovieCredits(movieId: Int, listener: APIListener<CreditsModel>) {

        val call = remote.getCredits(movieId)

        call.enqueue( object : Callback<CreditsModel> {
            override fun onResponse(call: Call<CreditsModel>, response: Response<CreditsModel>) {
                handleResponse(response,listener)
            }

            override fun onFailure(call: Call<CreditsModel>, t: Throwable) {
                listener.onFailure("Ocorreu um erro inesperado.")
            }


        })

    }

}