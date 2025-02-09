package com.ppereira.ui_core.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.ppereira.ui_core.theme.DarkBlue
import com.ppereira.ui_core.theme.DarkBlueAlpha
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.LightBlue
import com.ppereira.ui_core.theme.LightBlueAlpha
import com.ppereira.ui_core.theme.SpacingM
import com.ppereira.ui_core.theme.SpacingS

@Composable
fun ButtonLink(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = Modifier
            .clickable(role = Role.Button) { onClick.invoke() }
            .padding(all = SpacingM)
            .clip(RoundedCornerShape(SpacingS))
            .background(
                if (isSystemInDarkTheme()) LightBlueAlpha else DarkBlueAlpha,
                shape = RoundedCornerShape(SpacingS)
            )
            .padding(all = SpacingM),
        style = MaterialTheme.typography.titleMedium,
        text = label,
        color = if (isSystemInDarkTheme()) LightBlue else DarkBlue
    )
}

@PreviewLightDark
@Composable
private fun ButtonLinkPreview() {
    GitHubReposTheme {
        ButtonLink("Link Button", {})
    }
}

