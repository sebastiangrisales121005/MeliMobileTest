package com.ceiba.dataaccess.models

import com.google.gson.annotations.SerializedName

data class AddressResponse(
    @SerializedName("state_name")
    var stateName: String,
    @SerializedName("city_name")
    var cityName: String
)

data class SpecResponse(
    @SerializedName("name")
    var nameSpecs: String,
    @SerializedName("value_name")
    var valueSpecs: String
)