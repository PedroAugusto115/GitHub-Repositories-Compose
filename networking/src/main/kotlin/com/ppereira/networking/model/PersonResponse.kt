package com.ppereira.networking.model

import com.squareup.moshi.Json

class PersonResponse(
    @Json(name = "login") val name: String,
    @Json(name = "avatar_url") val avatarUrl: String
)
