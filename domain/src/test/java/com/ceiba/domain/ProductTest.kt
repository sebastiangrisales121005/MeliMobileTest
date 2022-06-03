package com.ceiba.domain

import com.ceiba.domain.core.ProductBuilderTest
import com.ceiba.domain.exception.ProductException
import com.ceiba.domain.models.Product
import org.junit.Assert
import org.junit.Test

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
}