package devandroid.zeglan.movies.server.model

import com.google.gson.annotations.SerializedName

data class MovieListModel(
    val genre: String?,
    @SerializedName("results")
    val list: List<MovieModel>
) {
    data class MovieModel(

        @SerializedName("id")
        val id: Int = 0,

        @SerializedName("poster_path")
        val poster_path: String? = "",

        @SerializedName("title")
        val title: String? = "",

    )
}