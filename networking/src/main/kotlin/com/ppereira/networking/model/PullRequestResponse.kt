package com.ppereira.networking.model

import com.squareup.moshi.Json

class PullRequestResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "title") val title: String,
    @Json(name = "body") val description: String? = "",
    @Json(name = "user") val user: PersonResponse,
    @Json(name = "created_at") val dateCreated: String,
    @Json(name = "html_url") val pullRequestUrl: String
)
