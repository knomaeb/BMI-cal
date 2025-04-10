package com.example.bmi_cal.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bmi_cal.ui.component.RoundedCard
import com.example.compose.BMICalTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.example.bmi_cal.ui.component.HeightSelector
import com.example.bmi_cal.ui.component.PickerView
import com.example.bmi_cal.ui.component.ResultCard
import com.example.bmi_cal.ui.component.RoundedButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Content(paddingValues: PaddingValues){
    val showResult = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(horizontal = 12.dp)
            .fillMaxSize(),
    ) {
        val heightState: MutableState<Int> = remember { mutableIntStateOf(170) }
        val weightState: MutableState<Int> = remember { mutableIntStateOf(62) }
        val ageState: MutableState<Int> = remember { mutableIntStateOf(20) }
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            var maleState by remember { mutableStateOf(false) }
            var femaleState by remember { mutableStateOf(false) }
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

        Spacer(Modifier.height(16.dp))

        HeightSelector(
            heightState = heightState
        )

        Spacer(Modifier.height(16.dp))

        PickerView(
            heightState = heightState,
            weightState = weightState,
            ageState = ageState
        )

        Spacer(Modifier.height(16.dp))

        if (showResult.value){
            ResultCard(
                height = heightState.value,
                weight = weightState.value,
                setShowResult = {
                    showResult.value = it
                }
            )
        }

        RoundedButton(
            modifier = Modifier
                .fillMaxWidth(),
            text = "Calculate",
            onClick = {
                showResult.value = true
            }
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HomeScreenPreview(){
    BMICalTheme {
        HomeScreen()
    }
}