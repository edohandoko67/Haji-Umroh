package com.natusi.hajidanumroh.model

import com.google.gson.annotations.SerializedName

data class Paket(
    @SerializedName("poster")
    var image: String,
    @SerializedName("data")
    var paket: List<Paket>
) {
    constructor(): this("", ArrayList()) {

    }
}
