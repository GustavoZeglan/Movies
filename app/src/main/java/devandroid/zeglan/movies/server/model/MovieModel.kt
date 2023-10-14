package devandroid.zeglan.movies.server.model

import com.google.gson.annotations.SerializedName

data class MovieListModel(
    val genre: String?,
    @SerializedName("results")
    val list: List<MovieModel>
) {
    data class MovieModel(
        @SerializedName("adult")
        var adult: Boolean = false,

//        @SerializedName("backdrop_path")
//        var backdrop_path: String? = "",
//
//        @SerializedName("genre_ids")
//        val genre_ids: List<Int> = arrayListOf(),

        @SerializedName("id")
        val id: Int = 0,

//        @SerializedName("original_language")
//        val original_language: String = "en",
//
//        @SerializedName("original_title")
//        val original_title: String = "",

        @SerializedName("overview")
        val overview: String = "",

//        @SerializedName("popularity")
//        val popularity: Double = 0.0,

        @SerializedName("poster_path")
        val poster_path: String = "",

//        @SerializedName("release_date")
//        val release_date: String = "",

        @SerializedName("title")
        val title: String = "",

//        @SerializedName("video")
//        val video: Boolean = false,
//
//        @SerializedName("vote_average")
//        val vote_average: Double = 0.0,
//
//        @SerializedName("vote_count")
//        val vote_count: Int = 0,
    )
}