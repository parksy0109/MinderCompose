package com.maro.tindercompose.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maro.tindercompose.ui.bar.BackArrowTopBar
import com.maro.tindercompose.ui.button.NextButton
import com.maro.tindercompose.ui.text.SubText
import com.maro.tindercompose.ui.text.TitleText
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SchoolInputScreen(
    navHostController: NavHostController,
    userJoinViewModel: UserJoinViewModel = viewModel(LocalContext.current as ComponentActivity),
    context: Context = LocalContext.current
) {
    Scaffold(
        topBar = {
            BackArrowTopBar {
                navHostController.popBackStack()
            }
        },
        bottomBar = {
            NextButton {
                if (userJoinViewModel.userJoinUiState.value.school.isNotEmpty()) {
                    navHostController.navigate(Screen.InterestsInputScreen.route)
                }else {
                    Toast.makeText(context, "본인이 출신/재학 중인 학교를 입력해주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(15.dp, 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TitleText(text = "출신/재학 중인 학교는 어디인가요?")
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = userJoinViewModel.userJoinUiState.value.school,
                    onValueChange = { value ->
                        userJoinViewModel.setSchool(value)
                    },
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = Color.White,
                        cursorColor = Color(0xFF7E8490),
                        textColor = Color.Black,
                        focusedIndicatorColor = Color(0xFF7E8490),
                        unfocusedIndicatorColor = Color(0xFF7E8490)
                    )
                )
                SubText(text = "프로필에 표시되는 이름입니다.")
            }
        }
    }
}