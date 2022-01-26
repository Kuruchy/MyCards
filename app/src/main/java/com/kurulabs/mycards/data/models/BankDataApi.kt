package com.kurulabs.mycards.data.models

import com.squareup.moshi.Json

data class BankDataApi(
    @field:Json(name = "entity") val entity: String
)