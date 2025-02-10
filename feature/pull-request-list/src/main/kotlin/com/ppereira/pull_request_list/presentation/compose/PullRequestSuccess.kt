package com.ppereira.pull_request_list.presentation.compose

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ppereira.networking.model.PersonResponse
import com.ppereira.pull_request_list.model.PullRequest
import com.ppereira.ui_core.component.AsyncRepoImage
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.SpacingL
import com.ppereira.ui_core.theme.SpacingM
import com.ppereira.ui_core.theme.SpacingS

@Composable
fun PullRequestSuccess(
    pullRequests: List<PullRequest>,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()
    val context = LocalContext.current
    LazyColumn(
        state = state,
        modifier = modifier
            .testTag("pulls_list_root")
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(SpacingL)
    ) {
        items(pullRequests) { pulls ->
            PullRequestItem(pulls) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(pulls.pullRequestUrl))
                context.startActivity(intent)
            }
        }
    }
}

@Composable
private fun PullRequestItem(
    pullRequest: PullRequest,
    onClick: (PullRequest) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = SpacingM)
            .clickable { onClick.invoke(pullRequest) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncRepoImage(
            url = pullRequest.user.avatarUrl,
            size = 80.dp
        )
        Spacer(modifier = Modifier.width(SpacingS))
        Column {
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = pullRequest.title,
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = pullRequest.description.take(100),
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall.copy(fontSize = 8.sp),
                text = pullRequest.dateCreated.take(100),
                textAlign = TextAlign.End
            )
        }
    }
}

@PreviewLightDark
@Composable
private fun PullRequestSuccessPreview() {
    GitHubReposTheme {
        PullRequestSuccess(
            listOf(
                PullRequest(
                    id = 1L,
                    title = "Making changes on line 324",
                    description = "Line 324 breaks Detekt Configuration, so I had to change it in order to CI succeeds",
                    user = PersonResponse("Test User", ""),
                    dateCreated = "2025-01-20",
                    pullRequestUrl = ""
                ),
                PullRequest(
                    id = 1L,
                    title = "Making changes on line 324",
                    description = "Line 324 breaks Detekt Configuration, so I had to change it in order to CI succeeds",
                    user = PersonResponse("Test User", ""),
                    dateCreated = "2025-01-20",
                    pullRequestUrl = ""
                )
            )
        )
    }
}
