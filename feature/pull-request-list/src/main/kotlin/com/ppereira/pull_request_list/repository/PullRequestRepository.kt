package com.ppereira.pull_request_list.repository

import com.ppereira.networking.model.PullRequestResponse
import com.ppereira.networking.provider.ApiProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PullRequestRepository(private val api: ApiProvider) {

    suspend fun getRepositoryPullRequests(
        creator: String,
        repository: String
    ): Flow<List<PullRequestResponse>> {
        val call = api.githubApi.getRepositoryPullRequests(creator, repository)
        return flow {
            try {
                if (call.isSuccessful && call.body() != null) {
                    val response = call.body()!!
                    emit(response)
                } else {
                    throw Exception()
                }
            } catch (ex: Exception) {
                throw Exception()
            }
        }
    }
}
