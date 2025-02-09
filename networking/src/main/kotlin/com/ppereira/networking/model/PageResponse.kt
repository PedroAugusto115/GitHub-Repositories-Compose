package com.ppereira.networking.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
class PageResponse(
    @Json(name = "items") val items: List<RepositoryResponse>,
    var nextPage: Int? = null
) : Parcelable
