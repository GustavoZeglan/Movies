package devandroid.zeglan.movies.server.repository.remote

import android.content.Context
import devandroid.zeglan.movies.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitClient() {

    companion object {

        private lateinit var INSTANCE: Retrofit

        fun getInstance() : Retrofit {

            val httpClient = OkHttpClient.Builder()

            httpClient.addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("accept", "application/json")
                    .addHeader("Authorization", Constants.USER.TOKEN)
                    .build()

                chain.proceed(request)
            }


            if (!::INSTANCE.isInitialized) {
                synchronized(RetrofitClient::class) {
                    INSTANCE = Retrofit.Builder()
                        .baseUrl("https://api.themoviedb.org/3/")
                        .client(httpClient.build())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
                return INSTANCE
        }

        fun <T> getService(service: Class<T>): T {
            return getInstance().create(service)
        }

    }


}