package com.example.design.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TextComponent(
    modifier: Modifier = Modifier,
    textValue: String,
    textColorValue: Color = Color.White,
    fontSizeValue: TextUnit = 16.sp
) {
    Text(
        text = textValue, modifier = modifier,
        style = TextStyle(
            color = textColorValue,
            fontSize = fontSizeValue
        ),
        textAlign = TextAlign.Center
    )



}