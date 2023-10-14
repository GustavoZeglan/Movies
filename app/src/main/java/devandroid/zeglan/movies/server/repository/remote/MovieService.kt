package devandroid.zeglan.movies.server.repository.remote

import devandroid.zeglan.movies.server.model.MovieDetailModel
import devandroid.zeglan.movies.server.model.MovieListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular?language=pt-br&page=1")
    fun getPopularMovies() : Call<MovieListModel>

    @GET("discover/movie")
    fun getFilteredMovies(@Query("with_genres") genres: String, @Query("language") language: String)
    : Call<MovieListModel>

    @GET("https://api.themoviedb.org/3/movie/{movieId}")
    fun getMovieDetail(@Path("movieId") id: Int, @Query("language") language: String  = "pt-br")
    : Call<MovieDetailModel>

}