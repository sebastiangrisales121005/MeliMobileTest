package com.ceiba.domain.models

data class ProductDetail(var title: String,
                         var price: Int,
                         var imageProduct: String,
                         var addressProduct: Address,
                         var specs: List<Specs>)
