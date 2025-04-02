package com.example.bmi_cal.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PickerView(
    heightState: MutableState<Int>,
    weightState: MutableState<Int>,
    ageState: MutableState<Int>
){
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NumberPicker(
                label = "Weight",
                modifier = Modifier
                    .fillMaxHeight(),
                pickerState = weightState
            )
            NumberPicker(
                label = "Age",
                modifier = Modifier
                    .fillMaxHeight(),
                pickerState = ageState
            )
        }
}

@Preview
@Composable
private fun PickerViewPreview(){
    PickerView(
        heightState = remember {mutableIntStateOf(170) } ,
        weightState = remember {mutableIntStateOf(55) },
        ageState = remember {mutableIntStateOf(22) }
    )
}