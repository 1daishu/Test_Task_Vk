package com.shubin.testtaskvk.data.mapper

import com.shubin.testtaskvk.data.network.dto.ProductDto
import com.shubin.testtaskvk.domain.model.Product
import com.shubin.testtaskvk.domain.model.ProductItem
import javax.inject.Inject

class DtoMapper @Inject constructor() {
    fun mapProductDtoToDomainItem(productDto: ProductDto) = Product(
        productDto.brand,
        productDto.category,
        productDto.description,
        productDto.discountPercentage,
        productDto.id,
        productDto.images,
        productDto.price,
        productDto.rating,
        productDto.stock,
        productDto.thumbnail,
        productDto.title
    )

    fun mapProductDomainItemToDto(product: Product) = ProductDto(
        product.brand,
        product.category,
        product.description,
        product.discountPercentage,
        product.id,
        product.images,
        product.price,
        product.rating,
        product.stock,
        product.thumbnail,
        product.title
    )
}