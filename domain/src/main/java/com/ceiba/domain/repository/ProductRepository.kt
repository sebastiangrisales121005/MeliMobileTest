package com.ceiba.domain.repository

import com.ceiba.domain.models.Product

interface ProductRepository {
    suspend fun getProducts(filterSearch: String): List<Product>
}