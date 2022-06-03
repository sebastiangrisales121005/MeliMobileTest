package com.ceiba.dataaccess.repository

import com.ceiba.domain.models.Product
import com.ceiba.domain.repository.ProductRepository

class ProductRepositoryImpl: ProductRepository {

    override suspend fun getProducts(): List<Product> {
        
    }
}