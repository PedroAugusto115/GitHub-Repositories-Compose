package com.ppereira.repository_list.presentation.compose

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import com.ppereira.repository_list.model.Page
import com.ppereira.repository_list.model.Person
import com.ppereira.repository_list.model.Repository
import com.ppereira.ui_core.component.AsyncRepoImage
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.SpacingM
import com.ppereira.ui_core.theme.SpacingS

@Composable
internal fun GitHubReposSuccess(
    page: Page,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyListState()
    LazyColumn(
        state = state,
        modifier = modifier
            .testTag("repos_list_root")
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(SpacingM)
    ) {
        items(page.items) { repository ->
            GitHubRepoItem(repository) {
                // TODO: Calls Pull Request screen
            }
        }
    }
}

@Composable
private fun GitHubRepoItem(
    repository: Repository,
    onClick: (Repository) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = SpacingM)
            .clickable { onClick.invoke(repository) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncRepoImage(
            url = repository.owner.avatarUrl,
            size = 80.dp
        )
        Spacer(modifier = Modifier.width(SpacingS))
        Column {
            Text(
                style = MaterialTheme.typography.titleMedium,
                text = repository.name,
            )
            Text(
                style = MaterialTheme.typography.bodySmall,
                text = repository.description.take(100),
            )
            Spacer(modifier = Modifier.height(4.dp))
            GitHubRepoItemCounters(
                repository.numberOfForks,
                repository.numberOfOpenIssues,
                repository.numberOfWatchers
            )
        }
    }
}

@Composable
private fun GitHubRepoItemCounters(
    numberOfForks: Int,
    numberOfOpenIssues: Int,
    numberOfWatchers: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextIcon(
            icon = com.ppereira.ui_core.R.drawable.icon_eye,
            text = numberOfWatchers.toString()
        )
        TextIcon(
            icon = com.ppereira.ui_core.R.drawable.icon_branch,
            text = numberOfForks.toString()
        )
        TextIcon(
            icon = com.ppereira.ui_core.R.drawable.icon_issue,
            text = numberOfOpenIssues.toString()
        )
    }
}

@Composable
private fun TextIcon(
    text: String,
    @DrawableRes icon: Int
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(icon),
            contentDescription = null,
            colorFilter = tint(color = MaterialTheme.colorScheme.primary)
        )
        Text(
            style = MaterialTheme.typography.titleMedium,
            text = text,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@PreviewLightDark
@Composable
private fun GitHubReposSuccessPreview() {
    GitHubReposTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            GitHubReposSuccess(
                Page(
                    listOf(
                        Repository(
                            id = 1L,
                            name = "Repository 1",
                            description = LoremIpsum(100).values.toList().toString(),
                            numberOfForks = 10,
                            numberOfWatchers = 100,
                            numberOfOpenIssues = 5,
                            owner = Person(
                                name = "Owner 1",
                                avatarUrl = "..."
                            )
                        ),
                        Repository(
                            id = 2L,
                            name = "Repository New",
                            description = LoremIpsum(150).values.toList().toString(),
                            numberOfForks = 10,
                            numberOfWatchers = 0,
                            numberOfOpenIssues = 5,
                            owner = Person(
                                name = "Owner 1",
                                avatarUrl = "..."
                            )
                        )
                    )
                )
            )
        }
    }
}


