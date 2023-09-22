package com.maro.tindercompose.ui.input

import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maro.tindercompose.viewmodel.UserJoinViewModel
import java.time.LocalDate


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BirthDayInput(
    userJoinViewModel: UserJoinViewModel = viewModel(LocalContext.current as ComponentActivity),
    context: Context = LocalContext.current
) {
    var year by remember { mutableStateOf("") }
    var month by remember { mutableStateOf("") }
    var day by remember { mutableStateOf("") }

    val focusRequests by remember { mutableStateOf(listOf(FocusRequester(), FocusRequester(), FocusRequester())) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        TextField(
            modifier = Modifier
                .focusRequester(focusRequests[0])
                .weight(0.4F),
            value = year,
            onValueChange = {
                if (it.length < 5) year = it
                try {
                    hasData(year, month, day)?.let { localDate -> userJoinViewModel.setBirthDay(localDate) }
                } catch (e: Exception) {
                    Toast.makeText(context, "형식에 맞게 데이터를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                if (it.length == 4) focusRequests[1].requestFocus()
            },
            placeholder = {
                Text(
                    text = "yyyy",
                    color = Color.Gray
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White
            ),
            maxLines = 1
        )
        Text(
            modifier = Modifier
                .weight(0.1F),
            text = "/"
        )
        TextField(
            modifier = Modifier
                .focusRequester(focusRequests[1])
                .weight(0.2f),
            value = month,
            onValueChange = {
                if(it.length < 3) month = it
                try {
                    hasData(year, month, day)?.let { localDate -> userJoinViewModel.setBirthDay(localDate) }
                } catch (e: Exception) {
                    Toast.makeText(context, "형식에 맞게 데이터를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
                if(it.length == 2) focusRequests[2].requestFocus()
            },
            placeholder = {
                Text(
                    text = "MM",
                    color = Color.Gray
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White
            ),
            maxLines = 1
        )
        Text(
            modifier = Modifier
                .weight(0.1f),
            text = "/"
        )
        TextField(
            modifier = Modifier
                .focusRequester(focusRequests[2])
                .weight(0.2f),
            value = day,
            onValueChange = {
                day = it
                try {
                    hasData(year, month, day)?.let { localDate -> userJoinViewModel.setBirthDay(localDate) }
                } catch (e: Exception) {
                    Toast.makeText(context, "형식에 맞게 데이터를 입력해주세요", Toast.LENGTH_SHORT).show()
                }
            },
            placeholder = {
                Text(
                    text = "dd",
                    color = Color.Gray
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                containerColor = Color.White
            ),
            maxLines = 1
        )
    }
}

private fun hasData(year: String, month: String, day: String): LocalDate? {
    return if (year.isNotEmpty() && month.isNotEmpty() && day.isNotEmpty()) {
        LocalDate.of(year.toInt(), month.toInt(), day.toInt())
    } else {
        null
    }
}

@Preview(showBackground = true)
@Composable
fun BirthDayInputPreview() {
    BirthDayInput()
}