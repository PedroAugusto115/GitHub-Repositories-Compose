package com.ppereira.feature_repos.presentation.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ppereira.feature_repos.model.Page

@Composable
internal fun GitHubReposSuccess(
    page: Page
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            DefaultToolbar(showBackIcon = false)
        }
    ) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = page.items.toString()
        )
    }
}