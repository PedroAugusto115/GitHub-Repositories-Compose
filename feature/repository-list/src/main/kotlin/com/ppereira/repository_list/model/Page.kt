package com.ppereira.repository_list.model

import android.os.Parcelable
import com.ppereira.networking.model.PageResponse
import com.ppereira.networking.model.PersonResponse
import com.ppereira.networking.model.RepositoryResponse
import kotlinx.parcelize.Parcelize

data class Page(
    val items: List<Repository>,
    val nextPage: Int? = 1
) {
    constructor(response: PageResponse) : this(
        items = response.items.map(::Repository),
        nextPage = response.nextPage
    )
}

@Parcelize
data class Repository(
    val id: Long,
    val name: String,
    val description: String,
    val numberOfForks: Int,
    val numberOfWatchers: Int,
    val numberOfOpenIssues: Int,
    val owner: Person
): Parcelable {
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

@Parcelize
data class Person(
    val name: String,
    val avatarUrl: String
): Parcelable {
    constructor(response: PersonResponse) : this(
        name = response.name,
        avatarUrl = response.avatarUrl
    )
}
