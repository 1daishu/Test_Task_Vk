package com.shubin.testtaskvk.data.network

import com.shubin.testtaskvk.data.network.dto.ResponseDtoProduct
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService {

    @GET("products")
    suspend fun getAllProduct(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): ResponseDtoProduct
}

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }).build()
        ).build()
    val networkService: NetworkService = retrofit.create(NetworkService::class.java)
}