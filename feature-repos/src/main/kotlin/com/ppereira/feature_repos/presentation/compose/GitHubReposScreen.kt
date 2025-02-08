package com.ppereira.feature_repos.presentation.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ppereira.feature_repos.presentation.model.UiState
import com.ppereira.feature_repos.viewmodel.GitHubReposViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun GitHubReposScreen(
    viewModel: GitHubReposViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getRepositories()
    }

    when (state.value) {
        is UiState.Loading -> GitHubReposLoading()
        is UiState.Error -> GitHubReposError()
        is UiState.Success -> GitHubReposSuccess(
            (state.value as UiState.Success).results
        )
        is UiState.Empty -> GitHubReposEmpty()
    }
}
