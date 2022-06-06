package com.ceiba.domain.models

import com.ceiba.domain.exception.ProductException
import java.io.Serializable

class Product constructor(
    var title: String,
    var price: Int,
    var imageProduct: String,
    var addressProduct: Address,
    var specs: List<Specs>): Serializable {
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