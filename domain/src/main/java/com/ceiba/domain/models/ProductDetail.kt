package com.ceiba.domain.models

data class ProductDetail(
    override var title: String,
    override var price: Int,
    override var imageProduct: String,
    var addressProduct: Address,
    var specs: List<Specs>): Product(title, price, imageProduct)
