package com.ceiba.dataaccess.anticorruption

import com.ceiba.dataaccess.models.AddressResponse
import com.ceiba.dataaccess.models.ProductResponse
import com.ceiba.dataaccess.models.SpecResponse
import com.ceiba.domain.models.Address
import com.ceiba.domain.models.Specs
import com.ceiba.domain.models.builder.ProductBuilder
import kotlin.collections.ArrayList

object ProductTranslator {
    fun fromApiToDomain(productResponse: ProductResponse): ProductBuilder  =
        ProductBuilder().apply {

        setTitle(productResponse.title)
        setPrice(productResponse.price)
        setImageProduct(productResponse.imageProduct)
        setAddress(fromAddressApiToAddress(productResponse.address))
        setSpecs(fromSpecsApiToSpecs(productResponse.specs))
    }

    private fun fromAddressApiToAddress(addressResponse: AddressResponse): Address =
        Address(addressResponse.stateName, addressResponse.cityName)

    private fun fromSpecsApiToSpecs(specResponse: List<SpecResponse>): List<Specs> {
        val listSpecs: ArrayList<Specs> = ArrayList()
        for (i in specResponse.indices) {
            listSpecs.add(Specs(specResponse[i].nameSpecs, specResponse[i].valueSpecs))
        }

        return listSpecs
    }
}