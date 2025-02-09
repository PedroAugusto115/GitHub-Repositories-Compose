package com.ppereira.ui_core.component

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage

@Composable
fun AsyncRepoImage(
    url: String,
    size: Dp,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(50.dp)),
        model = url,
        error = painterResource(id = com.ppereira.ui_core.R.drawable.octicons_github),
        placeholder = painterResource(id = com.ppereira.ui_core.R.drawable.octicons_github),
        contentDescription = null
    )
}
