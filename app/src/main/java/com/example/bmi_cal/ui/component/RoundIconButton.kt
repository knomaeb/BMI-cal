package com.example.bmi_cal.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bmi_cal.R
import com.example.compose.BMICalTheme
import com.example.compose.color04
import com.example.compose.surfaceContainerHighestLight

private val IconButtonSizeModifier = Modifier.size(48.dp)

@Composable
fun RoundedIconButton(
    imageIcon: Painter,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    tint: Color = Color.Black.copy(alpha = 0.8f),
    elevation: Dp = 2.dp
){
    Card(
        modifier = modifier.padding(all = 4.dp)
            .clickable(onClick = onClick)
            .then(IconButtonSizeModifier),
        shape = CircleShape,
        colors = CardDefaults.cardColors(color04),
        elevation = CardDefaults.cardElevation(defaultElevation = elevation)
    ) {
        Icon(
            imageIcon,
            null,
            tint = tint,
            modifier = Modifier
                .size(30.dp)
                .offset(x = 9.dp, y = 9.dp),
        )
    }
}

@Preview
@Composable
private fun RoundedIconButtonPreview() {
    BMICalTheme {
        RoundedIconButton(
            imageIcon = painterResource(R.drawable.remove_icon),
            onClick = {}
        )
    }
}