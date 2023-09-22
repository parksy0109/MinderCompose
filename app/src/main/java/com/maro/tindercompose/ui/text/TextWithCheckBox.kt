package com.maro.tindercompose.ui.text

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextWithCheckBox(
    description: String,
    isChecked: Boolean,
    setOnClickCheckBox: () -> Unit
) {

    Row(
        modifier = Modifier
            .wrapContentSize(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                setOnClickCheckBox()
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFF54C5E),
                uncheckedColor = Color(0xFFB8BFC9)
            )
        )
        Text(
            text = description,
            color = Color(0xFF525864)
        )
    }

}