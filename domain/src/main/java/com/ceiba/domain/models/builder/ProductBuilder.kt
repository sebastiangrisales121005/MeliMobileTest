package com.ceiba.domain.models.builder

import com.ceiba.domain.models.Address
import com.ceiba.domain.models.Product
import com.ceiba.domain.models.Specs

class ProductBuilder: Builder {
    private lateinit var title: String
    private var price: Int = 0
    private lateinit var imageProduct: String
    private lateinit var addressProduct: Address
    private lateinit var specs: List<Specs>

    override fun setTitle(title: String) {
        title.also { this.title = it }
    }

    override fun setPrice(price: Int) {
        price.also { this.price = it }
    }

    override fun setImageProduct(image: String) {
        image.also { this.imageProduct = it }
    }

    override fun setAddress(address: Address) {
        address.also { this.addressProduct = it }
    }

    override fun setSpecs(specs: List<Specs>) {
        specs.also { this.specs = specs }
    }

    fun build(): Product = Product(title, price, imageProduct, addressProduct, specs)


}