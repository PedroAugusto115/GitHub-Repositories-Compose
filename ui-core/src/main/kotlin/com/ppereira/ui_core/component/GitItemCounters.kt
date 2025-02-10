package com.ppereira.ui_core.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.res.painterResource
import com.ppereira.ui_core.R


@Composable
fun GitItemCounters(
    numberOfForks: Int,
    numberOfOpenIssues: Int,
    numberOfWatchers: Int
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        TextIcon(
            icon = R.drawable.icon_eye,
            text = numberOfWatchers.toString()
        )
        TextIcon(
            icon = R.drawable.icon_branch,
            text = numberOfForks.toString()
        )
        TextIcon(
            icon = R.drawable.icon_issue,
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
