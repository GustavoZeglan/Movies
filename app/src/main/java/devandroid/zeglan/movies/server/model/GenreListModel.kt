package devandroid.zeglan.movies.server.model

import com.google.gson.annotations.SerializedName

data class GenreListModel(
    @SerializedName("genres")
    val genres: List<GenreModel>
){

    data class GenreModel(
        @SerializedName("id")
        val id: String,

        @SerializedName("name")
        val name: String,
    )

}
