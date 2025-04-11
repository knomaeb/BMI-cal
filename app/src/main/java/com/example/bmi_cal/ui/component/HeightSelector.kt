package com.example.bmi_cal.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.color03
import com.example.compose.color05
import com.example.compose.color09

@Composable
fun HeightSelector(
    modifier: Modifier = Modifier,
    heightState: MutableState<Int>
){
    val height = buildAnnotatedString {
        withStyle(
            style = SpanStyle(fontSize = 32.sp, fontWeight = FontWeight.SemiBold)
        ) {
            append(heightState.value.toString())
        }
        append(" cm")
    }

    Card (
        modifier = Modifier,
        colors = CardDefaults.cardColors(color03)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Height", fontSize = 24.sp, color = color09, fontWeight = FontWeight.SemiBold)
                Text(text = height, fontSize = 18.sp, color = color09)
            }

            Slider(
                value = heightState.value.toFloat(),
                onValueChange = { heightState.value = it.toInt() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                valueRange = (1f..272f),
                colors = SliderDefaults.colors(
                    thumbColor = color09,
                    activeTrackColor = color09,
                    inactiveTrackColor = color05
                )
            )

        }
    }
}

@Preview
@Composable
private fun HeightSelectorPrev(){
    HeightSelector(
        heightState = remember { mutableIntStateOf(170) }
    )
}