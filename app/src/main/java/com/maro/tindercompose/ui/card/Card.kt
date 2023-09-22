package com.maro.tindercompose.ui.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.maro.tindercompose.ui.text.SecondaryText
import com.maro.tindercompose.ui.theme.PrimaryColor

@Composable
fun ImageTextCards(
    setOnClickListener: (String) -> Unit
) {
    var relations by remember {
        mutableStateOf(
            listOf(
                Triple("\uD83D\uDC98", "진지한 연애", false),
                Triple("\uD83D\uDE0D", "진지한 연애를\n찾지만\n캐주얼해도", false),
                Triple("\uD83E\uDD42", "캐주얼한\n연애를 찾지만\n진지해도", false),
                Triple("\uD83C\uDF89", "캐주얼하게\n만날 친구", false),
                Triple("\uD83D\uDC4B\uD83C\uDFFB", "새로운 동네\n 친구", false),
                Triple("\uD83E\uDD14", "아직 모르겠음", false),
            )
        )
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        itemsIndexed(relations) { index, item ->
            ImageTextCard(
                emojiText = item.first, description = item.second, isSelected = item.third,
                onItemSelectedListener = {
                    relations = relations.mapIndexed { indexMap, triple ->
                        Triple(triple.first, triple.second, index == indexMap)
                    }
                    setOnClickListener(item.second)
                }
            )
        }
    }
}

@Composable
fun ImageTextCard(
    emojiText: String,
    description: String,
    isSelected: Boolean,
    onItemSelectedListener: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(25.dp))
            .clickable {
                onItemSelectedListener()
            },
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(
            if (isSelected) {
                Color(0xFFFFFFFF)
            } else {
                Color(0xFFF1F2F4)
            }
        ),
        border = if (isSelected) {
            BorderStroke(2.dp, PrimaryColor)
        } else {
            null
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = emojiText,
                    fontSize = 30.sp
                )
                SecondaryText(text = description)
            }
        }
    }
}