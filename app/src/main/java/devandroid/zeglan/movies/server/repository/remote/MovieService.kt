package devandroid.zeglan.movies.server.repository.remote

import devandroid.zeglan.movies.Constants
import devandroid.zeglan.movies.server.model.CreditsModel
import devandroid.zeglan.movies.server.model.MovieDetailModel
import devandroid.zeglan.movies.server.model.MovieImages
import devandroid.zeglan.movies.server.model.MovieListModel
import devandroid.zeglan.movies.server.model.PostWatchList
import devandroid.zeglan.movies.server.model.ResponseWatchList
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("movie/popular?language=pt-br&page=1")
    fun getPopularMovies() : Call<MovieListModel>

    @GET("discover/movie")
    fun getFilteredMovies(@Query("with_genres") genres: String, @Query("language") language: String,
                          @Query("page") page: Int, @Query("sort_by") sort: String? = "popularity.desc")
    : Call<MovieListModel>

    @GET("https://api.themoviedb.org/3/movie/{movieId}")
    fun getMovieDetail(@Path("movieId") id: Int, @Query("language") language: String  = "pt-br")
    : Call<MovieDetailModel>

    @GET("https://api.themoviedb.org/3/movie/{movieId}/images")
    fun getMovieImages(@Path("movieId") id: Int, @Query("include_image_language") language: String = "pt")
    : Call<MovieImages>

    @GET("https://api.themoviedb.org/3/movie/{movieId}/credits")
    fun getCredits(@Path("movieId") id: Int, @Query("include_image_language") language: String = "pt")
    : Call<CreditsModel>

    @GET("https://api.themoviedb.org/3/account/{accountId}/watchlist/movies")
    fun getWatchList(@Path("accountId") id: Int = Constants.USER.ACCOUNTID, @Query("language") language: String = "pt-br")
    : Call<MovieListModel>

    @POST("https://api.themoviedb.org/3/account/{accountId}/watchlist")
    fun addOrRemoveMovieFromWatchList(@Path("accountId") accountId: Int = Constants.USER.ACCOUNTID, @Body body: PostWatchList)
    : Call<ResponseWatchList>

}