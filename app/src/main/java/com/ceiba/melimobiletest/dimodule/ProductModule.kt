package com.ceiba.melimobiletest.dimodule

import com.ceiba.dataaccess.repository.ProductRepositoryImpl
import com.ceiba.domain.repository.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ProductModule {

    @Binds
    abstract fun bindApiService(productRepositoryImpl: ProductRepositoryImpl): ProductRepository
}