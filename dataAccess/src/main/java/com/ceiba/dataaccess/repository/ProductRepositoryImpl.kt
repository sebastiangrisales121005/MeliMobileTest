package com.ceiba.dataaccess.repository

import com.ceiba.dataaccess.anticorruption.ProductTranslator
import com.ceiba.dataaccess.network.ApiInstance
import com.ceiba.domain.models.Product
import com.ceiba.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(): ProductRepository {
    private val apiService = ApiInstance.createApi()

    override suspend fun getProducts(filterSearch: String): List<Product> {
        val productsResponse = apiService.getProducts(filterSearch).execute().body()?.listProducts
        val listProducts = ArrayList<Product>()

        productsResponse?.let {
            for (i in productsResponse.indices) {
                listProducts.add(ProductTranslator.fromApiToDomain(productsResponse[i]).build())
            }
        }

        return listProducts
    }
}