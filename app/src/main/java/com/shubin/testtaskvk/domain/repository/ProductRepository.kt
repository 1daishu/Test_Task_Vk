package com.shubin.testtaskvk.domain.repository

import androidx.paging.Pager
import com.shubin.testtaskvk.domain.model.Product

interface ProductRepository {
    fun getProduct(): Pager<Int, Product>
}