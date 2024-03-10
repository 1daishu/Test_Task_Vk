package com.shubin.testtaskvk.data.repositoryImpl

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.shubin.testtaskvk.data.datasource.ProductDataSource
import com.shubin.testtaskvk.domain.model.Product
import com.shubin.testtaskvk.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource

) : ProductRepository {
    override fun getProduct(): Pager<Int, Product> = Pager(
        config = PagingConfig(ITEMS_PER_PAGE, enablePlaceholders = false),
        pagingSourceFactory = { productDataSource }
    )

    companion object {
        private const val ITEMS_PER_PAGE = 10
    }
}