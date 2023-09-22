package com.maro.tindercompose.ui.text

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        fontSize = 24.sp,
        fontWeight = FontWeight.Black
    )
}

@Composable
fun SecondaryText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF22262C),
        textAlign = TextAlign.Center
    )
}

@Composable
fun SubText(text: String) {
    Text(
        text = text,
        color = Color(0xFF515965),
        fontWeight = FontWeight.Bold
    )
}