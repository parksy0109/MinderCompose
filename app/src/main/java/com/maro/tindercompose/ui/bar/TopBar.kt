package com.maro.tindercompose.ui.bar

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun BackArrowTopBar(
    setOnClickListener: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {
        IconButton(onClick = {
            setOnClickListener()
        }) {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back Arrow Button")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BackArrowTopBarPreview(
) {
    BackArrowTopBar {}
}