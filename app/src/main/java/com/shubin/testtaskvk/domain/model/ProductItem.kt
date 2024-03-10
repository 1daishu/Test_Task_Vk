package com.shubin.testtaskvk.domain.model

data class ProductItem(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)