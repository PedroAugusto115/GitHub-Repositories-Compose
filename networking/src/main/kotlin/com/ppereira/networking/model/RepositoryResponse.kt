package com.ppereira.networking.model

import com.squareup.moshi.Json

class RepositoryResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "forks_count") val numberOfForks: Int,
    @Json(name = "stargazers_count") val numberOfWatchers: Int,
    @Json(name = "open_issues_count") val numberOfOpenIssues: Int,
    @Json(name = "owner") val owner: PersonResponse
)
