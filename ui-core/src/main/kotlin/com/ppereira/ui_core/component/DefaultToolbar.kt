package com.ppereira.ui_core.component

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.SpacingM
import com.ppereira.ui_core.theme.SpacingXS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultToolbar(
    showBackIcon: Boolean,
    name: String = "GitHub Repositories",
    avatarUrl: String? = null
) {
    val backPress = LocalOnBackPressedDispatcherOwner.current
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background
        ),
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                avatarUrl?.let { avatar ->
                    AsyncRepoImage(
                        url = avatar,
                        size = 24.dp
                    )
                    Spacer(modifier = Modifier.width(SpacingXS))
                }
                Text(
                    modifier = Modifier.semantics { heading() }.testTag("toolbar_default"),
                    style = MaterialTheme.typography.titleLarge,
                    text = name
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

@PreviewLightDark
@Composable
private fun DefaultToolbarPreview() {
    GitHubReposTheme {
        Column {
            DefaultToolbar(true)
            Spacer(modifier = Modifier.padding(top = SpacingM))
            DefaultToolbar(false)
        }
    }
}
