package devandroid.zeglan.movies.server.model

import com.google.gson.annotations.SerializedName

data class CreditsModel(

    @SerializedName("cast")
    val cast: List<People>

) {

    data class People (

        @SerializedName("id")
        val id: Int,
        @SerializedName("name")
        val name: String,
        @SerializedName("profile_path")
        val image: String,
        @SerializedName("gender")
        val gender: Int,
        @SerializedName("known_for_department")
        val department: String,
        @SerializedName("character")
        val character: String,

        )

}