package com.shubin.testtaskvk.data

import com.shubin.testtaskvk.data.network.Product
import retrofit2.Response
import retrofit2.http.GET

interface ProductService {
    @GET("products")
    suspend fun getAllProducts(): Response<Product>
}