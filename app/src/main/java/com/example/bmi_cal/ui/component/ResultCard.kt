package com.example.bmi_cal.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.bmi_cal.utils.BmiCalculator
import com.example.compose.BMICalTheme
import com.example.compose.outlineLight
import com.example.compose.surfaceContainerLight

@Composable
fun ResultCard(
    bmi : BmiCalculator,
    modifier: Modifier = Modifier,
    color: Color = surfaceContainerLight,
    elevation: Dp = 2.dp,
    content: @Composable () -> Unit
){
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(2.dp),
        colors = CardDefaults.cardColors(color),
        elevation = CardDefaults.cardElevation(elevation),
        border = BorderStroke(width = 1.dp, color = outlineLight)
    ){
        content()
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultCardPreview(){
    BMICalTheme {
        ResultCard(
            bmi = BmiCalculator(179, 55),
            modifier = Modifier,
            color = MaterialTheme.colorScheme.background,
            elevation = 4.dp
        ) {
            Text(text = "00.00", modifier = Modifier.padding(8.dp))
        }
    }
}