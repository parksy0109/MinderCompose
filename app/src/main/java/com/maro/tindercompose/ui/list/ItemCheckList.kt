package com.maro.tindercompose.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maro.tindercompose.ui.theme.PrimaryColor
import java.util.LinkedList
import java.util.Queue

@Composable
fun ItemCheckList(
    items: List<String>,
    setOnClickListener: (List<String>) -> Unit
) {

    var sexualOrientations by remember {
        mutableStateOf(
            items.map {
                it to false
            }
        )
    }

    val selectedQueue: Queue<String> = LinkedList()

    LazyColumn(
        modifier = Modifier
            .padding(horizontal = 15.dp)
    ) {
        itemsIndexed(sexualOrientations) { index, item ->
            ItemChecked(text = item.first, isChecked = item.second) {
                if(selectedQueue.contains(item.first)) {
                    selectedQueue.remove(item.first)
                }else {
                    if (selectedQueue.size >= 3) {
                        selectedQueue.remove()
                    }
                    selectedQueue.add(item.first)
                }

                setOnClickListener(selectedQueue.toList())

                sexualOrientations = sexualOrientations.map { it.first to selectedQueue.contains(it.first) }
            }
        }
    }

}

@Composable
fun ItemChecked(
    text: String,
    isChecked: Boolean,
    setOnClickListener: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(10.dp)
            .clickable {
                setOnClickListener()
            },
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = text,
            color = if (isChecked) Color.Black else Color(0xFF515965),
            fontWeight = if (isChecked) FontWeight.Bold else FontWeight.Normal
        )
        if (isChecked) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = "check image",
                tint = PrimaryColor
            )
        }
    }
}