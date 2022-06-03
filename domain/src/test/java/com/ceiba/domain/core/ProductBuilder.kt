package com.ceiba.domain.core

import com.ceiba.domain.models.Product

class ProductBuilderTest {
    var title: String
    var price: Int = 0
    var imageProduct: String

    companion object {
        fun aProduct(): ProductBuilderTest {
            return ProductBuilderTest()
        }
    }

    init {
        this.title = "Celular Motorola"
        this.price = 1200
        this.imageProduct = "http://mla-s2-p.mlstatic.com/795558-MLA31003306206_062019-I.jpg"
    }

    fun withTitle(title: String): ProductBuilderTest {
        this.title = title
        return this
    }

    fun withPrice(price: Int): ProductBuilderTest {
        this.price = price
        return this
    }

    fun withImageProduct(image: String): ProductBuilderTest {
        this.imageProduct = image
        return this
    }

    fun build(): Product {
        return Product(title, price, imageProduct)
    }
}