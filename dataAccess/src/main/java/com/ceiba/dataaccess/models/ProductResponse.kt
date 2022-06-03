package com.ceiba.dataaccess.models

import com.google.gson.annotations.SerializedName

data class ListProductResponse(
    @SerializedName("results")
    var listProducts: List<ProductResponse>)

data class ProductResponse(
    @SerializedName("title")
    var title: String,
    @SerializedName("price")
    var price: Double,
    @SerializedName("thumbnail")
    var imageProduct: String,
    @SerializedName("address")
    var address: AddressResponse,
    @SerializedName("attributes")
    var specs: List<SpecResponse>
)