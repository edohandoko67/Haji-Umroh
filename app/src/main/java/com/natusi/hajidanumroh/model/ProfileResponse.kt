package com.natusi.hajidanumroh.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("nama_perusahaan")
    private val namaPerusahaan: String,
    @SerializedName("logo_perusahaan")
    private val logo: String,
    @SerializedName("alamat")
    private val alamat: String,
    @SerializedName("no_telepon")
    private val noTelp: String,
    @SerializedName("email")
    private val email: String,
    @SerializedName("alamat_website")
    private val alamatWebsite: String,
    @SerializedName("profile_singkat_perusahaan")
    private val profile: String,
    @SerializedName("status")
    private val status: String,
    @SerializedName("code")
    private val code: Int,
    @SerializedName("data")
    private var profileResponse: List<ProfileResponse>? = null

)