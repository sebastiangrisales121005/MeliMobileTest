package com.ceiba.dataaccess.network

import com.ceiba.dataaccess.api.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiInstance {
    private const val URL = "https://api.mercadolibre.com/sites/MLA/"

    /**
     * Instancia retrofit para implenentación de consumo de webservice
     */
    fun createApi(): ApiService {
        val okHttpBuilder = OkHttpClient.Builder()
        okHttpBuilder.addInterceptor(HttpLoggingInterceptor())

        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpBuilder.build())
            .build()

        return retrofit.create(ApiService::class.java)
    }
}