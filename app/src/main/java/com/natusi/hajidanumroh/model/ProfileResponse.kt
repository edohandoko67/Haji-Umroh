package com.natusi.hajidanumroh.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("nama_perusahaan")
    var namaPerusahaan: String,
    @SerializedName("logo_perusahaan")
    var logo: String,
    @SerializedName("alamat")
    var alamat: String,
    @SerializedName("no_telepon")
    var noTelp: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("alamat_website")
    var alamatWebsite: String,
    @SerializedName("profile_singkat_perusahaan")
    var profile: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("code")
    var code: Int,
    @SerializedName("data")
    var profileResponse: List<ProfileResponse>? = null

) {
    constructor():
            this("","","","","","","",
                "",0, ArrayList()){

            }
}