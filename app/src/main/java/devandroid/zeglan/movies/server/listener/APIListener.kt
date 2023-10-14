package devandroid.zeglan.movies.server.listener


interface APIListener<T>{

    fun onSuccess(result: T)
    fun onFailure(message: String)

}