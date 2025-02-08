package com.ppereira.feature_repos.presentation.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
internal fun GitHubReposError() {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Text(
            modifier = Modifier.padding(innerPadding),
            text = "ERROR"
        )
    }
}