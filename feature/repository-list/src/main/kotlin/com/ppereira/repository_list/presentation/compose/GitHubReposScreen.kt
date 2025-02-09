package com.ppereira.repository_list.presentation.compose


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ppereira.repository_list.presentation.model.UiState
import com.ppereira.repository_list.viewmodel.GitHubReposViewModel
import com.ppereira.ui_core.component.DefaultToolbar
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun GitHubReposScreen(
    viewModel: GitHubReposViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getRepositories()
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultToolbar(showBackIcon = false)
        }
    ) { innerPadding ->
        when (state.value) {
            is UiState.Loading -> GitHubReposLoading(modifier = Modifier.padding(innerPadding))
            is UiState.Error -> GitHubReposError(
                onRetry = { viewModel.getRepositories() },
                modifier = Modifier.padding(innerPadding)
            )
            is UiState.Success -> GitHubReposSuccess(
                (state.value as UiState.Success).results,
                modifier = Modifier.padding(innerPadding)
            )
            is UiState.Empty -> GitHubReposEmpty(modifier = Modifier.padding(innerPadding))
        }
    }
}