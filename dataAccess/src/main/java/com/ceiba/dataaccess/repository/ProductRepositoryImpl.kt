package com.ceiba.dataaccess.repository

import com.ceiba.dataaccess.network.ApiInstance
import com.ceiba.domain.models.Product
import com.ceiba.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(): ProductRepository {
    val apiService = ApiInstance.createApi()

    override suspend fun getProducts(): List<Product> {
        return apiService.getProducts().listProducts
    }
}