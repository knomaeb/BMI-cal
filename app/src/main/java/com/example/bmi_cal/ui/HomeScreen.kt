package com.example.bmi_cal.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
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
        verticalArrangement = Arrangement.SpaceAround
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            var maleState by remember { mutableStateOf(true) }
            var femaleState by remember { mutableStateOf(true) }
            RoundedCard(
                modifier = Modifier.size(width = 180.dp, height = 100.dp),
                state = maleState,
                text = "Male",
                onClick = {
                    maleState = true
                    femaleState = false
                }
            )
            RoundedCard(
                modifier = Modifier.size(width = 180.dp, height = 100.dp),
                state = femaleState,
                text = "Female",
                onClick = {
                    maleState = false
                    femaleState = true
                }
            )
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