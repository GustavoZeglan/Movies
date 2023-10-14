package devandroid.zeglan.movies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import devandroid.zeglan.movies.server.listener.APIListener
import devandroid.zeglan.movies.server.model.GenreListModel
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.server.repository.remote.GenreRepository
import devandroid.zeglan.movies.server.repository.remote.MovieRepository
import java.lang.Exception

class MainViewModel(application: Application) : AndroidViewModel(application) {

    private val movieRepository = MovieRepository(application.applicationContext)
    private val genreRepository = GenreRepository(application.applicationContext)

    private var _movieListWithGenre = MutableLiveData<MutableList<MovieListModel>>()
    var movieListWithGenre: LiveData<MutableList<MovieListModel>> = _movieListWithGenre

    private var _popularMovieList = MutableLiveData<List<MovieListModel.MovieModel>>()
    var popularMovieList: LiveData<List<MovieListModel.MovieModel>> = _popularMovieList

    private var _genreList = MutableLiveData<List<GenreListModel.GenreModel>>()
    var genreList: LiveData<List<GenreListModel.GenreModel>> = _genreList

    fun popularFilms() {
        movieRepository.getPopularMovies( object : APIListener<MovieListModel> {
            override fun onSuccess(result: MovieListModel) {

                val popularMoviesList = parseToMovies(result)

                _popularMovieList.value = popularMoviesList

            }

            override fun onFailure(message: String) {
            }
        })
    }

    fun filteredMovies(genre: String, genreId: String) {

        movieRepository.getFilteredMovies(genreId,"pt-br", object : APIListener<MovieListModel> {

            override fun onSuccess(result: MovieListModel) {

                val filteredMoviesList = parseToMovies(result)
                val movieListModel = MovieListModel(genre,filteredMoviesList)

                var list = mutableListOf<MovieListModel>()
                list = _movieListWithGenre.value ?: list
                list.add(movieListModel)

                _movieListWithGenre.value = list

            }

            override fun onFailure(message: String) {
                val s = ""
            }

        })


    }

    fun getGenres(){
        genreRepository.getAllGenres( object : APIListener<GenreListModel> {

            override fun onSuccess(result: GenreListModel) {
                val genList = parseToGenres(result)
                _genreList.value = genList
            }

            override fun onFailure(message: String) {
                TODO("Not yet implemented")
            }

        })

    }

    private fun parseToMovies(movies: MovieListModel) : List<MovieListModel.MovieModel>{

        val moviesArray: ArrayList<MovieListModel.MovieModel> = ArrayList()
        val moviesList = movies.list

        for (i in 0 until moviesList.count()) {

            val adult = moviesList[i].adult
            val backdrop_path = moviesList[i].backdrop_path
            val genre_ids = moviesList[i].genre_ids
            val id = moviesList[i].id
            val original_language = moviesList[i].original_language
            val original_title = moviesList[i].original_title
            val overview = moviesList[i].overview
            val popularity = moviesList[i].popularity
            val poster_path = moviesList[i].poster_path
            val release_date = moviesList[i].release_date
            val title = moviesList[i].title
            val video = moviesList[i].video
            val vote_average = moviesList[i].vote_average
            val vote_count = moviesList[i].vote_count

            val movie = MovieListModel.MovieModel(
                adult = adult,
                backdrop_path = backdrop_path,
                genre_ids = genre_ids,
                id = id,
                original_language = original_language,
                original_title = original_title,
                overview = overview,
                popularity = popularity,
                poster_path = poster_path,
                release_date = release_date,
                title = title,
                video = video,
                vote_average = vote_average,
                vote_count = vote_count,
            )

            moviesArray.add(movie)

        }

        return moviesArray

    }

    private fun parseToGenres(genres: GenreListModel) : List<GenreListModel.GenreModel>{

        val genreArray: ArrayList<GenreListModel.GenreModel> = ArrayList()
        val genreList = genres.genres

        for (i in 0 until genreList.count()) {
            val id = genreList[i].id
            val name = genreList[i].name

            val genre: GenreListModel.GenreModel = GenreListModel.GenreModel(
                id,
                name
            )

            genreArray.add(genre)
        }

        return genreArray

    }


}

