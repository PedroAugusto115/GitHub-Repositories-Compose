package com.ppereira.networking.data

import com.ppereira.networking.model.PageResponse
import com.ppereira.networking.model.PullRequestResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RepoApi {
    @GET("/search/repositories")
    suspend fun getJavaRepositories(
        @Query("q") language: String = "language:Java",
        @Query("sort") sort: String = "stars",
        @Query("page") page: Int?
    ): Response<PageResponse>

    @GET("/repos/{creator}/{repository}/pulls")
    suspend fun getRepositoryPullRequests(
        @Path("creator") creator: String,
        @Path("repository") repository: String
    ): Response<List<PullRequestResponse>>
}
