package com.ppereira.networking.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
class PersonResponse(
    @Json(name = "login") val name: String,
    @Json(name = "avatar_url") val avatarUrl: String
) : Parcelable
