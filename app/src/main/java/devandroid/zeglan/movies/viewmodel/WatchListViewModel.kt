package devandroid.zeglan.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devandroid.zeglan.movies.server.listener.APIListener
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.server.repository.remote.MovieRepository

class WatchListViewModel(application: Application) : AndroidViewModel(application){

    private val remote = MovieRepository(application)

    private val _watchlist: MutableLiveData<List<MovieListModel.MovieModel>> = MutableLiveData<List<MovieListModel.MovieModel>>()
    val watchlist: LiveData<List<MovieListModel.MovieModel>> = _watchlist


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


}