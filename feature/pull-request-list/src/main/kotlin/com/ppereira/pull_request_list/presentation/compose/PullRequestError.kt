package com.ppereira.pull_request_list.presentation.compose

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.ppereira.ui_core.component.ButtonLink
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.SpacingM
import com.ppereira.ui_core.theme.SpacingXS

@Composable
internal fun PullRequestError(
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = SpacingM)
            .testTag("pulls_error_root"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = com.ppereira.ui_core.R.drawable.octicons_github),
            contentDescription = "Error image icon"
        )
        Spacer(modifier = Modifier.padding(top = SpacingXS))
        Text(
            modifier = Modifier,
            style = MaterialTheme.typography.titleMedium,
            text = "There was a problem loading Pull Requests"
        )
        ButtonLink(
            label = "Try again",
            onClick = onRetry
        )
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PullRequestErrorPreview() {
    GitHubReposTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            PullRequestError({})
        }
    }
}
