package com.ppereira.networking.model

import com.squareup.moshi.Json

class PageResponse(
    @Json(name = "items") val items: List<RepositoryResponse>,
    var nextPage: Int? = null
)
