package com.ceiba.dataaccess.anticorruption

import com.ceiba.dataaccess.models.AddressResponse
import com.ceiba.dataaccess.models.ProductResponse
import com.ceiba.dataaccess.models.SpecResponse
import com.ceiba.domain.models.Address
import com.ceiba.domain.models.Specs
import com.ceiba.domain.models.builder.ProductBuilder
import kotlin.collections.ArrayList

object ProductTranslator {
    /**
     * Método que traduce los datos del producto desde lo obtenido por medio del webservice al
     * conjunto de datos planteados en el dominio
     */
    fun fromApiToDomain(productResponse: ProductResponse): ProductBuilder  =
        ProductBuilder().apply {

        setTitle(productResponse.title)
        setPrice(productResponse.price.toInt())
        setImageProduct(productResponse.imageProduct)
        setAddress(fromAddressApiToAddress(productResponse.address))
        setSpecs(fromSpecsApiToSpecs(productResponse.specs))
    }

    /**
     * Traducción de los datos de la dirección del producto desde el webservice al
     * objeto plantaeado en el dominio
     */
    private fun fromAddressApiToAddress(addressResponse: AddressResponse): Address =
        Address(addressResponse.stateName, addressResponse.cityName)

    /**
     * Traducción de los datos de las características del producto desde el webservice al
     * objeto plantaeado en el dominio
     */
    private fun fromSpecsApiToSpecs(specResponse: List<SpecResponse>): List<Specs> {
        val listSpecs: ArrayList<Specs> = ArrayList()
        for (i in specResponse.indices) {
            listSpecs.add(Specs(specResponse[i].nameSpecs, specResponse[i].valueSpecs))
        }

        return listSpecs
    }
}