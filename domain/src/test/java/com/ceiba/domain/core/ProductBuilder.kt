package com.ceiba.domain.core

import com.ceiba.domain.models.Address
import com.ceiba.domain.models.Product
import com.ceiba.domain.models.Specs

class ProductBuilderTest {
    var title: String
    var price: Int = 0
    var imageProduct: String
    var address: Address
    var specs: List<Specs>

    companion object {
        fun aProduct(): ProductBuilderTest {
            return ProductBuilderTest()
        }
    }

    init {
        this.title = "Celular Motorola"
        this.price = 1200
        this.imageProduct = "http://mla-s2-p.mlstatic.com/795558-MLA31003306206_062019-I.jpg"
        this.address = Address("Risaralda", "Pereira")
        this.specs = mutableListOf(Specs("CPU", "Snapdragon"))
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

    fun withAddress(address: Address): ProductBuilderTest {
        this.address = address
        return this
    }

    fun withSpecs(specs: List<Specs>): ProductBuilderTest {
        this.specs = specs
        return this
    }

    fun build(): Product {
        return Product(title, price, imageProduct, address, specs)
    }
}