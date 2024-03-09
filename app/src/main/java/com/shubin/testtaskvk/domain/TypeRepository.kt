package com.shubin.testtaskvk.domain

import android.util.Log
import com.shubin.testtaskvk.data.ProductService
import com.shubin.testtaskvk.data.network.Product
import com.shubin.testtaskvk.data.network.ProductX
import retrofit2.Response
import javax.inject.Inject

class TypeRepository @Inject constructor(
    private val productService: ProductService
) {
    suspend fun getAllProduct(skip: Int, limit: Int): Response<Product> {
        return productService.getAllProducts(skip, limit)
    }
}