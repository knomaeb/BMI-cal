package com.example.bmi_cal.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.bmi_cal.utils.BmiCalculator
import com.example.compose.BMICalTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultCard(
    height: Int,
    weight: Int,
    modifier: Modifier = Modifier,
    setShowResult: (Boolean) -> Unit
){
    val bmiState = remember { mutableStateOf(BmiCalculator(height, weight)) }
    var showDialog by remember { mutableStateOf(false) }
    Dialog(onDismissRequest = {setShowResult(false)}) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            shape = RoundedCornerShape(16.dp),
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                OutlinedButton(
                    modifier = Modifier
                        .align(Alignment.End),
                    onClick = {
                        setShowResult(false)
                    }
                ) {
                    Image(imageVector = Icons.Default.Close, contentDescription = null)
                }
                ResultText(bmiState.value.bmi.toString())
            }
        }
    }
}

@Composable
fun ResultText(text: String){
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Your BMI is",
            fontSize = 20.sp
        )
        Text(
            modifier = Modifier,
            textAlign = TextAlign.Center,
            text = text,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ResultTextPrev(){
    ResultText(text = "25.56")
}