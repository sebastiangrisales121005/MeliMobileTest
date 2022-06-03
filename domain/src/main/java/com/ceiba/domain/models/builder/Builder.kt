package com.ceiba.domain.models.builder

import com.ceiba.domain.models.Address
import com.ceiba.domain.models.Specs

interface Builder {
    fun setTitle(title: String)
    fun setPrice(price: Int)
    fun setImageProduct(image: String)
    fun setAddress(address: Address)
    fun setSpecs(specs: List<Specs>)
}