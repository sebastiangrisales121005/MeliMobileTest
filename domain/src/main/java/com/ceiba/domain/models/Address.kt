package com.ceiba.domain.models

import com.ceiba.domain.exception.ProductException
import com.ceiba.domain.models.Product.Companion.MESSAGE_EMPTY

data class Address(var stateName: String,
                   var cityName: String) {
    init {
        validateDataEmpty()
    }
    private fun validateDataEmpty() {
        if (stateName.isEmpty() || cityName.isEmpty()) {
            throw ProductException(MESSAGE_EMPTY)
        }
    }
}
