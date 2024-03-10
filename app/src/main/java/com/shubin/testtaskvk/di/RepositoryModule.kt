package com.shubin.testtaskvk.di

import com.shubin.testtaskvk.data.repositoryImpl.ProductRepositoryImpl
import com.shubin.testtaskvk.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindsProductRepository(productRepositoryImpl: ProductRepositoryImpl): ProductRepository

}