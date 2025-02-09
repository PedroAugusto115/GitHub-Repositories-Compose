package com.ppereira.networking.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
class RepositoryResponse(
    @Json(name = "id") val id: Long,
    @Json(name = "name") val name: String,
    @Json(name = "description") val description: String,
    @Json(name = "forks_count") val numberOfForks: Long,
    @Json(name = "stargazers_count") val numberOfWatchers: Long,
    @Json(name = "open_issues_count") val numberOfOpenIssues: Long,
    @Json(name = "owner") val owner: PersonResponse
) : Parcelable
