package com.maro.tindercompose.ui.chips

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maro.tindercompose.ui.theme.PrimaryColor
import java.util.LinkedList
import java.util.Queue


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun Chips(
    setOnClickListener: (List<String>) -> Unit
) {
    var interests by remember {
        mutableStateOf(
            listOf(
                "베이킹" to false,
                "보드게임" to false,
                "블랙핑크" to false,
                "주짓수" to false,
                "주식" to false,
                "브이로그" to false,
                "커피 노점상" to false,
                "MLB" to false,
                "길거리 음식" to false,
                "기후변화" to false,
                "사회 개발" to false,
                "발레" to false,
                "오토바이" to false,
                "바디컴뱃" to false,
                "만화책" to false,
                "시" to false,
                "바디펌프" to false,
                "탁구" to false,
                "피크닉" to false,
            )
        )
    }

    val selectedQueue: Queue<String> = LinkedList()

    FlowRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(15.dp, 0.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        interests.forEach {
            FilterChip(
                selected = it.second,
                onClick = {
                    if (selectedQueue.contains(it.first)) {
                        selectedQueue.remove(it.first)
                    }else {
                        if(selectedQueue.size >= 5) {
                            selectedQueue.remove()
                        }
                        selectedQueue.add(it.first)
                    }

                    interests = interests.map { interest ->
                        interest.first to selectedQueue.contains(interest.first)
                    }

                    setOnClickListener(selectedQueue.toList())
                },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = PrimaryColor
                ),
                label = {
                    Text(
                        text = it.first,
                        color = if(it.second) Color.White else Color.Black
                    )
                }
            )
        }
    }

}