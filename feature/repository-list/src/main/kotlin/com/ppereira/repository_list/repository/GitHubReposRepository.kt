package com.ppereira.repository_list.repository

import com.ppereira.networking.model.PageResponse
import com.ppereira.networking.provider.ApiProvider
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class GitHubReposRepository(private val api: ApiProvider) {

    suspend fun listRepositories(): Flow<PageResponse> {
        val call = api.githubApi.getJavaRepositories(page = 1)
        return flow {
            try {
                if (call.isSuccessful && call.body() != null) {
                    val page = call.getNextPage()
                    val response = call.body()!!
                    response.nextPage = page
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

internal fun Response<PageResponse>.getNextPage(): Int? {
    val nextUrl = headers()["Link"]?.split(',')?.firstOrNull { it.contains("next") }
    return nextUrl?.substring(nextUrl.indexOf("page=") + 5)?.split(">")?.firstOrNull()?.toInt()
}