package com.kurulabs.mycards.data.models

import com.squareup.moshi.Json

data class CardDataApi(
    @field:Json(name = "card") val card: String,
    @field:Json(name = "card_formatted") val cardFormatted: String,
    @field:Json(name = "expiration_date") val expirationDate: String,
    @field:Json(name = "cvc") val cvc: String,
    @field:Json(name = "name") val name: String
)