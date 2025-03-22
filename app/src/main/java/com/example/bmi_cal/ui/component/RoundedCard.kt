package com.example.bmi_cal.ui.component

import androidx.compose.foundation.layout.padding
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
            .padding(20.dp),
        shape = RoundedCornerShape(4.dp),
        colors = CardDefaults.cardColors(surfaceContainerLight),
        elevation = CardDefaults.cardElevation(4.dp),
    ){
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(15.dp),
            textAlign = TextAlign.Center
        )
        if (text == "Male"){
            Icon(
                painter = painterResource(R.drawable.ic_male_icon_background),
                contentDescription = null,
            )
        }else{
            Icon(
                painter = painterResource(R.drawable.ic_female_icon_background),
                contentDescription = null,
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