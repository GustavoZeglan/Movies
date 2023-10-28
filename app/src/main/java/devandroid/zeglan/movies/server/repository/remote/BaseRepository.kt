package devandroid.zeglan.movies.server.repository.remote

import com.google.gson.Gson
import devandroid.zeglan.movies.server.listener.APIListener
import retrofit2.Response

open class BaseRepository {

    private fun failResponse(str: String): String {
        return Gson().fromJson(str, String::class.java)
    }

    fun <T> handleResponse(response: Response<T>, listener: APIListener<T>) {
        if(response.code() == 200) {
            response.body()?.let { listener.onSuccess(it) }
        }else {
            listener.onFailure(response.errorBody().toString())
        }
    }

}