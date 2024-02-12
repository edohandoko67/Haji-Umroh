package com.natusi.hajidanumroh.model

import com.google.gson.annotations.SerializedName

data class DataPaket(
    @SerializedName("id_paket_umroh")
    var id: Int,
    @SerializedName("poster")
    var image: String,
    @SerializedName("data")
    var paket: List<DataPaket>
) {
    constructor(): this(0,"", ArrayList()) {

    }
}
