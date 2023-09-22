package com.maro.tindercompose.ui.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SelectGenderButtons(
    buttonNames: List<String>,
    setOnClickListener: (String) -> Unit
) {

    var uiState by remember { mutableStateOf(buttonNames.map { it to false }) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        uiState.forEachIndexed { index, pair ->
            TransparentBorderRadiusButton(buttonText = pair.first, isSelected = pair.second) {
                uiState = buttonNames.mapIndexed { mapIndex, s -> s to (index == mapIndex) }
                setOnClickListener(pair.first)
            }
        }
    }

}

@Composable
fun TransparentBorderRadiusButton(
    buttonText: String,
    isSelected: Boolean,
    setOnClickListener: () -> Unit,
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(25.dp))
            .clickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {
                    setOnClickListener()
                }
            ),
        shape = RoundedCornerShape(25.dp),
        border = if(isSelected) BorderStroke(2.dp, Color(0xFFF54C5E)) else BorderStroke(2.dp, Color(0xFFB8BFC9)),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        )
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                text = buttonText,
                fontWeight = FontWeight.Black,
                fontSize = 16.sp
            )
        }
    }
}