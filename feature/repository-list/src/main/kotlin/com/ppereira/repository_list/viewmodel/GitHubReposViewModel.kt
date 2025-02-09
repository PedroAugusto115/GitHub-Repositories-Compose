package com.ppereira.repository_list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ppereira.repository_list.model.Page
import com.ppereira.repository_list.presentation.model.UiState
import com.ppereira.repository_list.repository.GitHubReposRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class GitHubReposViewModel(
    private val repository: GitHubReposRepository
) : ViewModel() {

    private val _state = MutableStateFlow<UiState>(UiState.Loading)
    val state = _state.asStateFlow()

    fun getRepositories() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            repository.listRepositories()
                .catch { _state.value = UiState.Error }
                .collect { pageResponse ->
                    _state.value = UiState.Success(Page(pageResponse))
                }
        }
    }
}
