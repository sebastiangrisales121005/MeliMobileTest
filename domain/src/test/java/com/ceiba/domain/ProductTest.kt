package com.ceiba.domain

import com.ceiba.domain.core.ProductBuilderTest
import com.ceiba.domain.exception.ProductException
import com.ceiba.domain.models.Address
import com.ceiba.domain.models.Product
import com.ceiba.domain.repository.ProductRepository
import com.ceiba.domain.usecases.ProductUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class ProductTest {
    @Test
    fun product_validateDataEmpty_isFailure() {
        //Arrange
        val productBuilder = ProductBuilderTest.aProduct()
            .withTitle("")
            .withImageProduct("")

        val expectedMessage = Product.MESSAGE_EMPTY

        try {
            //Act
            productBuilder.build()
        } catch (exception: ProductException) {
            //Assert
            Assert.assertEquals(expectedMessage, exception.message)
        }
    }

    @Test
    fun product_validateAddressEmpty_isFailure() {
        //Arrange
        val expectedMessage = Product.MESSAGE_EMPTY

        try {
            //Act
            Address("", "")
        } catch (exception: ProductException) {
            //Assert
            Assert.assertEquals(expectedMessage, exception.message)
        }
    }

    @Test
    fun product_getAllProducts_isSuccess() = runBlocking {
        //Arrange
        val productBuilder = ProductBuilderTest.aProduct()
            .build()
        val productList = listOf(productBuilder)
        val productRepository = Mockito.mock(ProductRepository::class.java)
        `when`(productRepository.getProducts("Motorola")).thenReturn(productList)
        val productUseCase = ProductUseCase(productRepository)

        //Act
        val productsFromUseCase = productUseCase.getProducts("Motorola")

        //Assert
        Assert.assertEquals(1, productsFromUseCase.size)

    }

    @Test
    fun product_getProductsEmpty_isSuccess() = runBlocking {
        //Arrange
        val productRepository = Mockito.mock(ProductRepository::class.java)
        `when`(productRepository.getProducts("Motorola")).thenReturn(listOf())
        val productUseCase = ProductUseCase(productRepository)

        //Act
        val productsFromUseCase = productUseCase.getProducts("Motorola")

        //Assert
        Assert.assertEquals(0, productsFromUseCase.size)

    }
}