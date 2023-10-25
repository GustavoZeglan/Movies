package devandroid.zeglan.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devandroid.zeglan.movies.server.listener.APIListener
import devandroid.zeglan.movies.server.model.CreditsModel
import devandroid.zeglan.movies.server.model.MovieDetailModel
import devandroid.zeglan.movies.server.model.MovieImages
import devandroid.zeglan.movies.server.repository.remote.MovieRepository

class MovieDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val remote = MovieRepository(application.applicationContext)

    private var _movie: MutableLiveData<MovieDetailModel> = MutableLiveData<MovieDetailModel>()
    var movie: LiveData<MovieDetailModel> = _movie

    private var _movieImages: MutableLiveData<MovieImages> = MutableLiveData<MovieImages>()
    var movieImages: LiveData<MovieImages> = _movieImages

    private val _cast: MutableLiveData<List<CreditsModel.People>> = MutableLiveData<List<CreditsModel.People>>()
    val cast: LiveData<List<CreditsModel.People>> = _cast

    //private var _posterImage: MutableLiveData<String> = MutableLiveData<String>()
    //var posterImage: LiveData<String> = _posterImage

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

//    fun getBestPosterImage(){
//
//        var movieImage: MovieImages.MovieImage =
//            MovieImages.MovieImage(0,"",0.0,0.0)
//
//        for (i in _movieImages.value!!.posters) {
//
//            if(i.height > movieImage.height && i.voteAverage >= movieImage.voteAverage && i.voteCount >= movieImage.voteCount) {
//                movieImage = i
//            }
//
//        }
//
//        _posterImage.value = movieImage.filePath
//    }

}