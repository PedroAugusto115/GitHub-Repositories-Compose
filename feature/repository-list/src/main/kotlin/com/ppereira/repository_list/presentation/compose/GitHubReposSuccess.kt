package com.ppereira.repository_list.presentation.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ppereira.repository_list.model.Page

@Composable
internal fun GitHubReposSuccess(
    page: Page,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = modifier,
        text = page.items.toString()
    )
}
