package com.ceiba.dataaccess.api

import com.ceiba.dataaccess.models.ListProductResponse
import com.ceiba.dataaccess.models.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("search")
    fun getProducts(@Query("q") query: String): Call<ListProductResponse>
}