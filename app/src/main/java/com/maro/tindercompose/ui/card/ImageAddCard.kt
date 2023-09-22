package com.maro.tindercompose.ui.card

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maro.tindercompose.ui.theme.PrimaryColor

@Composable
fun ImageAddCards() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(6) {
            ImageAddCard()
        }
    }
}

@Composable
fun ImageAddCard() {
    Box(
        modifier = Modifier
            .wrapContentSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp)
                .height(150.dp)
                .drawBehind {
                    drawRoundRect(
                        color = Color(0xFFB8BFC9),
                        style = Stroke(
                            width = 10f,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                        ),
                        cornerRadius = CornerRadius(16.dp.toPx())
                    )
                },
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(
                Color(0xFFEAEBEF)
            ),
        ) {
        }
        Card(
            modifier = Modifier
                .align(Alignment.BottomEnd),
            shape = CircleShape,
            colors = CardDefaults.cardColors(
                PrimaryColor
            ),
        ) {
            Icon(
                imageVector = Icons.Default.Add, contentDescription = null, tint = Color.White
            )
        }
    }

}

@Preview
@Composable
fun ImageAddCardsPreview() {
    ImageAddCards()
}