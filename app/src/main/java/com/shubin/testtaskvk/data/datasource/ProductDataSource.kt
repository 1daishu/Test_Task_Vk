package com.shubin.testtaskvk.data.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shubin.testtaskvk.data.mapper.DtoMapper
import com.shubin.testtaskvk.data.network.RetrofitInstance
import com.shubin.testtaskvk.domain.model.Product
import javax.inject.Inject

class ProductDataSource @Inject constructor(
    private val dtoMapper: DtoMapper
) : PagingSource<Int, Product>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val page = params.key ?: STARTING_PAGE
        return try {
            val response = RetrofitInstance.networkService.getAllProduct(page * PAGE_SIZE, PAGE_SIZE)
            val products = response.products.map { dtoMapper.mapProductDtoToDomainItem(it) }
            LoadResult.Page(
                data = products,
                prevKey = if (page == STARTING_PAGE) null else page - 1,
                nextKey = if (products.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)?.prevKey ?: state.closestPageToPosition(anchorPosition)?.nextKey
            anchorPage ?: STARTING_PAGE
        }
    }
    companion object {
        private const val STARTING_PAGE = 0
        private const val PAGE_SIZE = 20
    }
}