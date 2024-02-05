package com.natusi.hajidanumroh.model

import com.google.gson.annotations.SerializedName

data class DataPaket(
    @SerializedName("poster")
    var image: String,
    @SerializedName("data")
    var paket: List<DataPaket>
) {
    constructor(): this("", ArrayList()) {

    }
}
