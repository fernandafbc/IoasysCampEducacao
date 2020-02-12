package br.com.ioasys.camp.educao.service.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL: String = "https://api-edu.herokuapp.com/"

    val retrofitClient: Retrofit.Builder by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient.build())
            .addConverterFactory(GsonConverterFactory.create())
    }
    //    okHttpClient and interceptor optional
    private val okHttpClient: OkHttpClient.Builder by lazy {
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })


    }

    val apiService = retrofitClient.build()
        .create(APIService::class.java)

}