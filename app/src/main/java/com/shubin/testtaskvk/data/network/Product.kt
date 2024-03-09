package com.shubin.testtaskvk.data.network

data class Product(
    val limit: Int,
    val products: List<ProductX>,
    val skip: Int,
    val total: Int
)