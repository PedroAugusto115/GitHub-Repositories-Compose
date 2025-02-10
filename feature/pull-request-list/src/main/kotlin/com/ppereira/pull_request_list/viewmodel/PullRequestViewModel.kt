package com.ppereira.pull_request_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ppereira.networking.ui.UiState
import com.ppereira.pull_request_list.model.PullRequest
import com.ppereira.pull_request_list.repository.PullRequestRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class PullRequestViewModel(
    private val repository: PullRequestRepository
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()

    fun getRepositoryPullRequests(
        creator: String,
        repositoryName: String
    ) {
        viewModelScope.launch {
            _state.value = UiState.Loading
            repository.getRepositoryPullRequests(creator, repositoryName)
                .catch { _state.value = UiState.Error }
                .collect { response ->
                    _state.value = UiState.Success(response.map(::PullRequest))
                }
        }
    }
}
