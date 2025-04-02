package com.example.bmi_cal.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.BMICalTheme
import com.example.compose.onSurfaceLight

@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,
    state: Boolean,
    text: String,
    onClick: () -> Unit,
){
    val cardModifier = if (state){
        modifier
            .size(width = 180.dp, height = 50.dp)
            .border(2.dp, onSurfaceLight)
    }else{
        modifier
            .size(width = 180.dp, height = 50.dp)
    }

    Card(
        onClick = onClick,
        cardModifier,
        shape = RoundedCornerShape(4.dp),
        elevation = CardDefaults.cardElevation(2.dp),
    ){
        Text(
            text = text,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxSize().offset(y = 12.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview
@Composable
private fun RoundedCardPreview(){
    BMICalTheme {
        var maleState by remember { mutableStateOf(true) }
        var femaleState by remember { mutableStateOf(true) }
        RoundedCard(
            modifier = Modifier,
            state = maleState,
            text = "Male",
            onClick = {
                maleState = true
                femaleState = false
            }
        )
    }
}

@Preview
@Composable
private fun RoundedCardPreviewF(){
    BMICalTheme {
        var maleState by remember { mutableStateOf(true) }
        var femaleState by remember { mutableStateOf(true) }
        RoundedCard(
            modifier = Modifier,
            state = maleState,
            text = "Female",
            onClick = {
                maleState = true
                femaleState = false
            }
        )
    }
}