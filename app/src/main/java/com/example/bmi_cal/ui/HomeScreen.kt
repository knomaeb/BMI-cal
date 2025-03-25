package com.example.bmi_cal.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmi_cal.ui.component.RoundedCard
import com.example.compose.BMICalTheme
import com.example.compose.onSurfaceLight
import com.example.compose.surfaceLight
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.example.bmi_cal.ui.component.ResultCard
import com.example.bmi_cal.ui.component.RoundedButton
import com.example.bmi_cal.ui.component.RoundedIconButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarColors(
                    containerColor = surfaceLight,
                    titleContentColor = onSurfaceLight,
                    scrolledContainerColor = onSurfaceLight,
                    navigationIconContentColor = onSurfaceLight,
                    actionIconContentColor = onSurfaceLight
                ),
                title = {
                    Text("BMI Calculator")
                }
            )
        },
        content = { paddingValues ->
            Content(paddingValues)
        }
    )
}

@Composable
private fun Content(paddingValues: PaddingValues){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val heightState = remember { mutableStateOf(170) }
        val weightState: MutableState<Int> = remember { mutableStateOf(62) }
        val ageState: MutableState<Int> = remember { mutableStateOf(20) }
        ResultCard(
            height = heightState.value,
            weight = weightState.value,
            modifier = Modifier,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            var maleState by remember { mutableStateOf(true) }
            var femaleState by remember { mutableStateOf(true) }
            RoundedCard(
                state = maleState,
                text = "Male",
                onClick = {
                    maleState = true
                    femaleState = false
                }
            )
            RoundedCard(
                state = femaleState,
                text = "Female",
                onClick = {
                    maleState = false
                    femaleState = true
                }
            )
        }


        PickerView(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            heightState = heightState,
            weightState = weightState,
            ageState = ageState
        )
        RoundedButton(
            modifier = Modifier
                .padding(10.dp),
            text = "Calculate",
            onClick = {

            }
        )
    }
}

@Composable
private fun PickerView(
    modifier: Modifier = Modifier,
    heightState: MutableState<Int>,
    weightState: MutableState<Int>,
    ageState: MutableState<Int>
){
    Column(
        modifier = modifier
            .padding(start = 15.dp, end = 15.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeightSelector(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 8.dp)
                .fillMaxHeight(),
            heightState = heightState
        )
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
}

@Composable
private fun HeightSelector(
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
        modifier = Modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
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
                Text(text = "Height", fontSize = 18.sp)
                Text(text = height, fontSize = 18.sp)
            }

            Slider(
                value = heightState.value.toFloat(),
                onValueChange = { heightState.value = it.toInt() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                valueRange = (1f..272f),
                colors = SliderDefaults.colors(
                    activeTrackColor = onSurfaceLight
                )
            )

        }
    }
}

@Composable
private fun NumberPicker(
    label: String,
    modifier: Modifier = Modifier,
    pickerState: MutableState<Int>,
    range: IntRange = 1..100
){
    Card(
        modifier = Modifier
            .size(width = 150.dp, height = 150.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = label,
                modifier = Modifier
            )
            Text(
                text = pickerState.value.toString(),
                modifier = Modifier
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                RoundedIconButton(imageVector = Icons.Default.KeyboardArrowUp, onClick = {
                    if (pickerState.value < range.last){
                        pickerState.value++
                    }
                })
                RoundedIconButton(imageVector = Icons.Default.KeyboardArrowDown, onClick = {
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
private fun HomeScreenPreview(){
    BMICalTheme {
        HomeScreen()
    }
}