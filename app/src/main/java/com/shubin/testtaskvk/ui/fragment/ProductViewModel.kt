package com.shubin.testtaskvk.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.shubin.testtaskvk.domain.model.Product
import com.shubin.testtaskvk.domain.usecase.ProductUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductViewModel @Inject constructor(
    private val useCase: ProductUseCase
) : ViewModel() {
    val items: Flow<PagingData<Product>> = useCase()
        .flow
        .cachedIn(viewModelScope)
}