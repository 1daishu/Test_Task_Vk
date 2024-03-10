package com.shubin.testtaskvk.domain.usecase

import com.shubin.testtaskvk.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke() = repository.getProduct()
}