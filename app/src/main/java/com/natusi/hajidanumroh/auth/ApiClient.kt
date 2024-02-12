package com.natusi.hajidanumroh.auth

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiClient {
    private var retrofit: Retrofit? = null
    private const val BASE_URL = "http://192.168.2.111/"
    final const val URL_IMAGE = "http://192.168.2.111/develop/KBIHU_Al-Rahmah/public/foto-paket/"
    fun getRetrofitInstance(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }
}