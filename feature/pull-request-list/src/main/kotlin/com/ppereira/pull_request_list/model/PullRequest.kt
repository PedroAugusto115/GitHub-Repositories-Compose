package com.ppereira.pull_request_list.model

import com.ppereira.networking.model.PersonResponse
import com.ppereira.networking.model.PullRequestResponse

class PullRequest(
    val id: Long,
    val title: String,
    val description: String = "",
    val user: PersonResponse,
    val dateCreated: String,
    val pullRequestUrl: String
) {
    constructor(response: PullRequestResponse) : this (
        id = response.id,
        title = response.title,
        description = response.description ?: "",
        user = response.user,
        dateCreated = response.dateCreated,
        pullRequestUrl = response.pullRequestUrl,
    )
}
