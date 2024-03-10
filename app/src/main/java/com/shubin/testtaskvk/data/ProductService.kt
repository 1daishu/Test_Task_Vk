package com.shubin.testtaskvk.data

import com.shubin.testtaskvk.domain.model.ProductItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("products")
    suspend fun getAllProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int
    ): Response<ProductItem>
}