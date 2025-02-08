package com.ppereira.feature_repos.presentation.compose

import androidx.activity.OnBackPressedDispatcher
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import com.ppereira.feature_repos.ui.theme.GitHubReposTheme
import com.ppereira.feature_repos.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun DefaultToolbar(showBackIcon: Boolean) {
    val backPress = LocalOnBackPressedDispatcherOwner.current
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    modifier = Modifier.semantics { heading() }.testTag("toolbar_default"),
                    style = Typography.titleLarge,
                    text = "GitHub Repositories"
                )
            }
        },
        navigationIcon = {
            if (showBackIcon) {
                IconButton(onClick = {
                    backPress?.onBackPressedDispatcher?.onBackPressed()
                }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "menu items"
                    )
                }
            }
        }
    )
}

@Preview(showSystemUi = true, )
@Composable
private fun DefaultToolbarPreview() {
    GitHubReposTheme {
        DefaultToolbar(false)
    }
}