package com.maro.tindercompose.ui.bar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ScreenProgressTopBar(
    currentScreen: Float,
    totalScreen: Float
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(8.dp),
    ) {
        Box(
            modifier = Modifier
                .weight(currentScreen)
                .fillMaxHeight()
                .background(Brush.horizontalGradient(listOf(Color(0xFFFD2F70), Color(0xFFFE4753), Color(0xFFFE5840)))),
        )
        if(currentScreen != totalScreen) {
            Box(
                modifier = Modifier
                    .weight(totalScreen - currentScreen)
                    .fillMaxHeight()
                    .background(Color(0xFFEAEBEF)),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressTopBarPreview() {
    ScreenProgressTopBar(9F, 9F)
}