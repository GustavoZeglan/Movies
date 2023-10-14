package devandroid.zeglan.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devandroid.zeglan.movies.server.listener.APIListener
import devandroid.zeglan.movies.server.model.MovieDetailModel
import devandroid.zeglan.movies.server.repository.remote.MovieRepository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val remote = MovieRepository(application.applicationContext)

    private var _movie: MutableLiveData<MovieDetailModel> = MutableLiveData<MovieDetailModel>()
    var movie: LiveData<MovieDetailModel> = _movie

//    private var _movieId: MutableLiveData<Int> = MutableLiveData<Int>()
//    var movieId: LiveData<Int> = _movieId

    fun getMovieDetail(movieId: Int) {

        remote.getMovieDetail(movieId, object : APIListener<MovieDetailModel> {
            override fun onSuccess(result: MovieDetailModel) {
                _movie.value = result
            }

            override fun onFailure(message: String) {
                val s = ""
            }

        })

    }


}