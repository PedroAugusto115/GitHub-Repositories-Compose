package com.ppereira.feature_repos.model

import com.ppereira.networking.model.PageResponse
import com.ppereira.networking.model.PersonResponse
import com.ppereira.networking.model.PullRequestResponse
import com.ppereira.networking.model.RepositoryResponse

data class Page(
    val items: List<Repository>,
    val nextPage: Int? = 1
) {
    constructor(response: PageResponse) : this(
        items = response.items.map(::Repository),
        nextPage = response.nextPage
    )
}

data class Repository(
    val id: Long,
    val name: String,
    val description: String,
    val numberOfForks: Long,
    val numberOfWatchers: Long,
    val numberOfOpenIssues: Long,
    val owner: Person
) {
    constructor(response: RepositoryResponse) : this(
        id = response.id,
        name = response.name,
        description = response.description,
        numberOfForks = response.numberOfForks,
        numberOfWatchers = response.numberOfWatchers,
        numberOfOpenIssues = response.numberOfOpenIssues,
        owner = Person(response.owner)
    )
}

data class PullRequest(
    val id: Long,
    val title: String,
    val description: String = "",
    val user: Person,
    val dateCreated: String,
    val pullRequestUrl: String
) {
    constructor(response: PullRequestResponse) : this(
        id = response.id,
        title = response.title,
        description = response.description,
        user = Person(response.user),
        dateCreated = response.dateCreated,
        pullRequestUrl = response.pullRequestUrl,
    )
}

data class Person(
    val name: String,
    val avatarUrl: String
) {
    constructor(response: PersonResponse) : this(
        name = response.name,
        avatarUrl = response.avatarUrl
    )
}
