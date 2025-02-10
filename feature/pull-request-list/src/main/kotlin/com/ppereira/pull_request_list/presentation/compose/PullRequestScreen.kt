package com.ppereira.pull_request_list.presentation.compose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ppereira.networking.ui.UiState
import com.ppereira.pull_request_list.model.PullRequest
import com.ppereira.pull_request_list.viewmodel.PullRequestViewModel
import com.ppereira.ui_core.component.DefaultToolbar
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.SpacingL
import com.ppereira.ui_core.theme.SpacingM
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PullRequestScreen(
    creator: String,
    creatorUrl: String,
    repositoryName: String,
    viewModel: PullRequestViewModel = koinViewModel()
) {
    val state = viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.getRepositoryPullRequests(creator, repositoryName)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            PullRequestsHeader(
                creatorUrl,
                repositoryName
            )
        }
    ) { innerPadding ->
        when (state.value) {
            is UiState.Loading -> PullRequestLoading(modifier = Modifier.padding(innerPadding))
            is UiState.Error -> PullRequestError(
                onRetry = { viewModel.getRepositoryPullRequests(creator, repositoryName) },
                modifier = Modifier.padding(innerPadding)
            )

            is UiState.Success<*> -> PullRequestSuccess(
                (state.value as UiState.Success<List<PullRequest>>).results,
                modifier = Modifier.padding(innerPadding)
            )

            is UiState.Empty -> PullRequestEmpty(modifier = Modifier.padding(innerPadding))
        }
    }
}

@Composable
private fun PullRequestsHeader(
    creatorUrl: String,
    repositoryName: String
) {
    Column {
        DefaultToolbar(
            showBackIcon = true,
            name = repositoryName,
            avatarUrl = creatorUrl
        )
        Spacer(modifier = Modifier.height(SpacingM))
        Text(
            text = "Pull Requests",
            modifier = Modifier.padding(horizontal = SpacingM),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(SpacingL))
    }
}

@PreviewLightDark
@Composable
fun PullRequestsHeaderPreview() {
    GitHubReposTheme {
        PullRequestsHeader(
            "...",
            "Kotlin Repository"
        )
    }
}
