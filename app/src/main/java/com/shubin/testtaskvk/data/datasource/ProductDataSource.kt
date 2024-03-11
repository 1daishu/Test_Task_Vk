package com.shubin.testtaskvk.data.datasource

import android.widget.Toast
import androidx.paging.LoadState
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shubin.testtaskvk.data.mapper.DtoMapper
import com.shubin.testtaskvk.data.network.RetrofitInstance
import com.shubin.testtaskvk.domain.model.Product
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min

class ProductDataSource @Inject constructor(
    private val dtoMapper: DtoMapper
) : PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int {
        return STARTING_PAGE
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        val page = params.key ?: STARTING_PAGE
        return runCatching {
            RetrofitInstance.networkService.getAllProduct(page, PAGE_SIZE).products.map {
                dtoMapper.mapProductDtoToDomainItem(it)
            }
        }.fold(
            onSuccess = {
                LoadResult.Page(
                    data = it,
                    prevKey = if (page == STARTING_PAGE) null else page - 1,
                    nextKey = if (page == PAGE_SIZE) null else ensureValidKey(page + 1)
                )
            },
            onFailure = {
                LoadResult.Error(it)
            }
        )
    }

    private fun ensureValidKey(page: Int) = min(max(STARTING_PAGE, page), PAGE_SIZE)

    companion object {
        private const val STARTING_PAGE = 0
        private const val PAGE_SIZE = 20
    }
}