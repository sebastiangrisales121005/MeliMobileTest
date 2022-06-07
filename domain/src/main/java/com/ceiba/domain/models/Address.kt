package com.ceiba.domain.models

import com.ceiba.domain.exception.ProductException
import com.ceiba.domain.models.Product.Companion.MESSAGE_EMPTY
import java.io.Serializable

data class Address(var stateName: String,
                   var cityName: String): Serializable {
    init {
        validateDataEmpty()
    }

    /**
     * Método que valida la transparencia de los datos de dirección para
     * que estos no se obtengan vacíos
     */
    private fun validateDataEmpty() {
        if (stateName.isEmpty() || cityName.isEmpty()) {
            throw ProductException(MESSAGE_EMPTY)
        }
    }
}
