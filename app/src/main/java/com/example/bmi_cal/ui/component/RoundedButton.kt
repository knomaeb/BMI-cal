package com.example.bmi_cal.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.BMICalTheme
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceLight

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    text: String,
    elevation: Dp = 4.dp,
    onClick: () -> Unit,
    backgroundColor: Color = onSurfaceLight,
    contentColor: Color = surfaceLight
){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(4.dp),
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor,
            contentColor = contentColor
        ),
        elevation = ButtonDefaults.elevatedButtonElevation(elevation)
    ){
        Text(text = text, fontSize = 18.sp)
    }
}

@Preview(showSystemUi = true)
@Composable
private fun RoundedButtonPreview(){
    BMICalTheme {
        RoundedButton(
            text = "RoundedButton",
            onClick = {}
        )
    }
}