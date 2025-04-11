package com.example.bmi_cal.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi_cal.R
import com.example.compose.BMICalTheme
import com.example.compose.color03
import com.example.compose.color09
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
            .size(width = 150.dp, height = 120.dp)
            .border(2.dp, onSurfaceLight)
    }else{
        modifier
            .size(width = 150.dp, height = 120.dp)
    }

    Card(
        onClick = onClick,
        cardModifier,
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(color03),
        elevation = CardDefaults.cardElevation(2.dp),
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                tint = color09,
                contentDescription = null,
                painter =
                    if (text == "Male") painterResource(R.drawable.icons_male) else painterResource(R.drawable.icons_female)
            )
            Text(
                text = text,
                color = color09,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxSize().offset(y = 12.dp),
                textAlign = TextAlign.Center,
            )
        }
        
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RoundedCardPreviewF(){
    BMICalTheme {
        var maleState by remember { mutableStateOf(true) }
        var femaleState by remember { mutableStateOf(true) }
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            RoundedCard(
                modifier = Modifier,
                state = maleState,
                text = "Female",
                onClick = {
                    maleState = true
                    femaleState = false
                }
            )
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
}