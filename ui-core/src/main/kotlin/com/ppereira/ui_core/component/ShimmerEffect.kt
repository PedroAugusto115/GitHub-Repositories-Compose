package com.ppereira.ui_core.component

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ppereira.ui_core.theme.GitHubReposTheme
import com.ppereira.ui_core.theme.SpacingL
import com.ppereira.ui_core.theme.SpacingM
import com.ppereira.ui_core.theme.SpacingS

@Composable
fun CircleShimmerEffect(
    size: Dp,
    modifier: Modifier = Modifier
) {
    ShimmerEffect(
        modifier = modifier
            .size(size)
            .clip(RoundedCornerShape(50.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(50))
    )
}

@Composable
fun CardShimmerEffect(
    height: Dp,
    modifier: Modifier = Modifier
) {
    ShimmerEffect(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
            .clip(RoundedCornerShape(SpacingS))
            .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(SpacingS))
    )
}

@Composable
fun LineShimmerEffect(
    width: Dp,
    modifier: Modifier = Modifier
) {
    ShimmerEffect(
        modifier
            .width(width)
            .height(SpacingL)
            .clip(RoundedCornerShape(SpacingL))
            .background(MaterialTheme.colorScheme.surfaceVariant)
    )
}

@Composable
fun ProfileShimmerEffect(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(
            space = SpacingM,
            alignment = Alignment.CenterHorizontally
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CircleShimmerEffect(80.dp)
        Column(
            modifier = Modifier
        ) {
            LineShimmerEffect(320.dp)
            Spacer(modifier = Modifier.height(SpacingS))
            LineShimmerEffect(120.dp)
            Spacer(modifier = Modifier.height(4.dp))
            LoadingCircles()
        }
    }
}

@Composable
private fun LoadingCircles() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CircleShimmerEffect(30.dp)
        CircleShimmerEffect(30.dp)
        CircleShimmerEffect(30.dp)
    }
}

@Composable
fun ShimmerEffect(
    modifier: Modifier,
    widthOfShadowBrush: Int = 400,
    angleOfAxisY: Float = 270f,
    durationMillis: Int = 800,
) {
    val shimmerColors = listOf(
        MaterialTheme.colorScheme.background.copy(alpha = 0.3f),
        MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
        MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
        MaterialTheme.colorScheme.background.copy(alpha = 0.5f),
        MaterialTheme.colorScheme.background.copy(alpha = 0.3f),
    )

    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "Shimmer loading animation",
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = 0.0f),
        end = Offset(x = translateAnimation.value, y = angleOfAxisY),
    )

    Box(
        modifier = modifier
    ) {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(brush)
        )
    }
}

@PreviewLightDark
@Composable
fun ShimmerEffectPreview() {
    GitHubReposTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(all = SpacingM)
        ) {
            Spacer(modifier = Modifier.height(SpacingL))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Absolute.SpaceBetween
            ) {
                repeat(5) {
                    CircleShimmerEffect(60.dp)
                }
            }

            Spacer(modifier = Modifier.height(SpacingL))

            CardShimmerEffect(60.dp)

            Spacer(modifier = Modifier.height(SpacingL))

            ProfileShimmerEffect()

            Spacer(modifier = Modifier.height(SpacingL))

            CardShimmerEffect(220.dp)
        }
    }
}
