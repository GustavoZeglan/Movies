package devandroid.zeglan.movies.server.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PostWatchList(
    @SerializedName("media_type")
    @Expose
    val mediaType: String,
    @SerializedName("media_id")
    @Expose
    val mediaId: Int,
    @SerializedName("watchlist")
    @Expose
    val watchlist: Boolean,
)

data class ResponseWatchList(
    @SerializedName("success")
    val success: String,
    @SerializedName("status_code")
    val status_code: Int,
    @SerializedName("status_message")
    val status_message: String
)