package com.ppereira.ui_core.component

import android.content.res.Configuration
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ppereira.ui_core.theme.DarkBlue
import com.ppereira.ui_core.theme.DarkBlueAlpha
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.LightBlue
import com.ppereira.ui_core.theme.LightBlueAlpha

@Composable
fun ButtonLink(
    label: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Text(
        modifier = Modifier
            .clickable(role = Role.Button) { onClick.invoke() }
            .padding(all = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                if (isSystemInDarkTheme()) LightBlueAlpha else DarkBlueAlpha,
                shape = RoundedCornerShape(12.dp)
            )
            .padding(all = 16.dp),
        style = MaterialTheme.typography.titleMedium,
        text = label,
        color = if (isSystemInDarkTheme()) LightBlue else DarkBlue
    )
}

@Preview(name = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview(name = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
private fun ButtonLinkPreview() {
    GitHubReposTheme {
        ButtonLink("Link Button", {})
    }
}

