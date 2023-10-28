package devandroid.zeglan.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devandroid.zeglan.movies.R
import devandroid.zeglan.movies.server.listener.APIListener
import devandroid.zeglan.movies.server.model.CreditsModel
import devandroid.zeglan.movies.server.model.MovieDetailModel
import devandroid.zeglan.movies.server.model.MovieImages
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.server.model.ResponseWatchList
import devandroid.zeglan.movies.server.repository.remote.MovieRepository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val remote = MovieRepository(application.applicationContext)

    private var _movie: MutableLiveData<MovieDetailModel> = MutableLiveData<MovieDetailModel>()
    var movie: LiveData<MovieDetailModel> = _movie

    private var _movieImages: MutableLiveData<MovieImages> = MutableLiveData<MovieImages>()
    var movieImages: LiveData<MovieImages> = _movieImages

    private val _cast: MutableLiveData<List<CreditsModel.People>> = MutableLiveData<List<CreditsModel.People>>()
    val cast: LiveData<List<CreditsModel.People>> = _cast

    private val _watchlist: MutableLiveData<List<MovieListModel.MovieModel>> = MutableLiveData<List<MovieListModel.MovieModel>>()
    val watchlist: LiveData<List<MovieListModel.MovieModel>> = _watchlist

    private val _isUpdated: MutableLiveData<String> = MutableLiveData<String>()
    val isUpdated: LiveData<String> = _isUpdated

    private val _movieIsInWatchList: MutableLiveData<Boolean> = MutableLiveData<Boolean>()
    val movieIsInWatchList: LiveData<Boolean> = _movieIsInWatchList

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

    fun getMovieImages(movieId: Int) {

        remote.getMovieImages(movieId, object : APIListener<MovieImages> {
            override fun onSuccess(result: MovieImages) {
                _movieImages.value = result
            }

            override fun onFailure(message: String) {
                val s = ""
            }

        })

    }

    fun getCast(movieId: Int) {
        remote.getMovieCredits(movieId, object : APIListener<CreditsModel> {
            override fun onSuccess(result: CreditsModel) {
                _cast.value = result.cast
            }

            override fun onFailure(message: String) {
                val s = ""
            }

        })
    }

    fun getWatchList() {
        remote.getWatchList( object : APIListener<MovieListModel> {

            override fun onSuccess(result: MovieListModel) {
                _watchlist.value = result.list
            }

            override fun onFailure(message: String) {
                val s = ""
            }

        })
    }

    fun addOrRemoveMovieFromWatchList(mediaType: String, mediaId: Int, watchlist: Boolean) {
        remote.addOrRemoveMovieFromWatchList(mediaType, mediaId, watchlist, object : APIListener<ResponseWatchList> {
            override fun onSuccess(result: ResponseWatchList) {
                _isUpdated.value = result.status_message
            }

            override fun onFailure(message: String) {
                val s = ""
            }

        })
    }

    fun verifyIfMovieIsInWatchList(movieId: Int) : Boolean {
        val watchListFiltered = watchlist.value!!.filter { it.id == movieId}
        _movieIsInWatchList.value = watchListFiltered.isNotEmpty()
        return _movieIsInWatchList.value!!
    }

    fun switchMovieIsInWatchList(bool: Boolean) {
        _movieIsInWatchList.value = bool
    }

}