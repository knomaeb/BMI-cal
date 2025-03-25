package com.example.bmi_cal.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.compose.BMICalTheme
import com.example.compose.surfaceContainerHighestLight

private val RippleRadius = 24.dp
private val IconButtonSizeModifier = Modifier.size(48.dp)

@Composable
fun RoundedIconButton(
    imageVector: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = Color.Black.copy(alpha = 0.8f),
    backgroundColor: Color = surfaceContainerHighestLight,
    elevation: Dp = 2.dp
){
    Card(
        modifier = modifier.padding(all = 4.dp)
            .clickable(onClick = onClick)
            .then(IconButtonSizeModifier),
        shape = CircleShape,
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Icon(
            imageVector,
            null,
            tint = tint,
            modifier = Modifier
                .fillMaxSize(),
        )
    }
}

@Preview
@Composable
private fun RoundedIconButtonPreview() {
    BMICalTheme {
        RoundedIconButton(
            imageVector = Icons.Outlined.Notifications,
            onClick = {}
        )
    }
}