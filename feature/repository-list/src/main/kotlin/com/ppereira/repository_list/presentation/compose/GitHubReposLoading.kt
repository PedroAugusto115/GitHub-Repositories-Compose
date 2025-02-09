package com.ppereira.repository_list.presentation.compose

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import com.ppereira.ui_core.component.ProfileShimmerEffect
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.SpacingM

@Composable
internal fun GitHubReposLoading(modifier: Modifier = Modifier) {
    Column(modifier = modifier
        .padding(horizontal = SpacingM)
        .testTag("repos_loading_root")
    ) {
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
        Spacer(modifier = Modifier.height(SpacingM))
        ProfileShimmerEffect()
    }
}

@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
internal fun GitHubReposLoadingPreview() {
    GitHubReposTheme {
        Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
            GitHubReposLoading()
        }
    }
}
