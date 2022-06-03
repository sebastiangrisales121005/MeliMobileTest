package com.ceiba.domain.models

abstract class Product(
    open var title: String,
    open var price: Int,
    open var imageProduct: String)