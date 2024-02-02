package com.natusi.hajidanumroh.auth

import com.natusi.hajidanumroh.model.ProfileResponse
import retrofit2.Call
import retrofit2.http.GET


interface API {
    @GET("develop/KBIHU_Al-Rahmah/public/api/profile")
    fun getProfile(): Call<ProfileResponse?>?

//    @GET("develop/KBIHU_Al-Rahmah/public/api/paket-umroh")
//    fun getDataPaket(): Call<DataPaket?>?
}