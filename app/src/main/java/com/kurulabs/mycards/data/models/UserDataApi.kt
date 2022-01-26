package com.kurulabs.mycards.data.models

import com.squareup.moshi.Json

data class UserDataApi(
    @field:Json(name = "fullname") val fullname: String
)