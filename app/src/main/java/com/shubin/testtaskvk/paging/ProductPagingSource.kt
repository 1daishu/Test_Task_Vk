package com.shubin.testtaskvk.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shubin.testtaskvk.data.network.Product
import com.shubin.testtaskvk.domain.TypeRepository
import retrofit2.HttpException

class ProductPagingSource(
    private val repository: TypeRepository
) : PagingSource<Int, List<Product>>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, List<Product>> {
        return try {
            val currentPage = params.key ?: 1
            val response = repository.getAllProduct(currentPage, 20)
            val data = response.body()?.products
            val responseData = mutableListOf<List<Product>>()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        } catch (httpError: HttpException) {
            LoadResult.Error(httpError)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, List<Product>>): Int? {
        return null
    }


}