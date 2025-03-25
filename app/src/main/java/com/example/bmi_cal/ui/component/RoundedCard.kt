package com.example.bmi_cal.ui.component

import android.graphics.Color
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.example.bmi_cal.R
import androidx.compose.ui.unit.sp
import com.example.compose.BMICalTheme
import com.example.compose.surfaceContainerLight

@Composable
fun RoundedCard(
    modifier: Modifier = Modifier,
    state: Boolean,
    text: String,
    onClick: () -> Unit,
){
    Card(
        onClick = onClick,
        modifier = modifier
            .padding(20.dp)
            .size(width = 150.dp, height = 150.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(surfaceContainerLight),
        elevation = CardDefaults.cardElevation(2.dp),
    ){
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (text == "Male"){
                Icon(
                    painter = painterResource(R.drawable.icons_male),
                    contentDescription = null,
                )
            }else{
                Icon(
                    painter = painterResource(R.drawable.icons_female),
                    contentDescription = null,
                )
            }

            Text(
                text = text,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }


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