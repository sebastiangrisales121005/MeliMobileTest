package com.ceiba.domain.models

import com.ceiba.domain.exception.ProductException

open class Product(
    open var title: String,
    open var price: Int = 0,
    open var imageProduct: String) {

    companion object {
        const val MESSAGE_EMPTY = "Tenemos algunos inconvenientes, por favor intente de nuevo"
    }

    init {
        validateProductEmpty()
    }

    private fun validateProductEmpty() {
        if (title.isEmpty() || imageProduct.isEmpty()) {
            throw ProductException(MESSAGE_EMPTY)
        }
    }
}