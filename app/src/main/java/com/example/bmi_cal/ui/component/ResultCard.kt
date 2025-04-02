package com.example.bmi_cal.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_cal.utils.BmiCalculator
import com.example.compose.BMICalTheme

@Composable
fun ResultCard(
    height: Int,
    weight: Int,
    modifier: Modifier = Modifier,
){
    val bmiState = remember { mutableStateOf(BmiCalculator(height, weight)) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .size(width = 200.dp, height = 100.dp),
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(2.dp),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Your BMI is",
                fontWeight = FontWeight.SemiBold,
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier,
                textAlign = TextAlign.Center,
                text = bmiState.value.bmi.toString(),
                fontSize = 35.sp,
                fontWeight = FontWeight.Bold
            )
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ResultCardPreview(){
    BMICalTheme {
        ResultCard(
            height = 179,
            weight = 62,
            modifier = Modifier,
        )
    }
}