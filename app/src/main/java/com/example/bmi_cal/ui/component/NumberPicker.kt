package com.example.bmi_cal.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_cal.R

@Composable
fun NumberPicker(
    label: String,
    modifier: Modifier = Modifier,
    pickerState: MutableState<Int>,
    range: IntRange = 1..100
){
    Card(
        modifier = Modifier
            .size(width = 180.dp, height = 150.dp),
        shape = RoundedCornerShape(4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                modifier = Modifier,
                fontSize = 25.sp,
                fontWeight = FontWeight.SemiBold
            )
            Text(
                text = pickerState.value.toString(),
                modifier = Modifier,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RoundedIconButton(imageIcon = painterResource(R.drawable.add_icon), onClick = {
                    if (pickerState.value < range.last){
                        pickerState.value++
                    }
                })
                RoundedIconButton(imageIcon = painterResource(R.drawable.remove_icon), onClick = {
                    if (pickerState.value > range.first) {
                        pickerState.value--
                    }
                })
            }

        }
    }
}

@Preview
@Composable
private fun NumberPickerPreview(){
    NumberPicker(
        label = "Age",
        modifier = Modifier
            .fillMaxHeight(),
        pickerState = remember { mutableIntStateOf(22) }
    )
}