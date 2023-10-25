package devandroid.zeglan.movies.server.model

import com.google.gson.annotations.SerializedName

data class MovieImages(

    @SerializedName("backdrops")
    val backdrops: List<MovieImage>,
    @SerializedName("logos")
    val logos: List<MovieImage>,
    @SerializedName("posters")
    val posters: List<MovieImage>,

) {

    data class MovieImage (

            @SerializedName("height")
            val height: Int,
            @SerializedName("file_path")
            val filePath: String,
            @SerializedName("vote_average")
            val voteAverage: Double,
            @SerializedName("vote_count")
            val voteCount: Double,
            )

}

