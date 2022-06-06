package com.ceiba.domain.usecases

import com.ceiba.domain.models.Product
import com.ceiba.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun getProducts(filterSearch: String): List<Product> = productRepository.getProducts(filterSearch)
}