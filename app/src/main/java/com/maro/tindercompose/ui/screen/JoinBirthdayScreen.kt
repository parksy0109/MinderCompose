package com.maro.tindercompose.ui.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maro.tindercompose.ui.bar.BackArrowTopBar
import com.maro.tindercompose.ui.button.NextButton
import com.maro.tindercompose.ui.input.BirthDayInput
import com.maro.tindercompose.ui.text.SubText
import com.maro.tindercompose.ui.text.TitleText
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JoinBirthdayScreen(
    navHostController: NavHostController,
    userJoinViewModel: UserJoinViewModel = viewModel(LocalContext.current as ComponentActivity),
    context: Context = LocalContext.current
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            BackArrowTopBar {
                navHostController.popBackStack()
            }
        },
        bottomBar = {
            NextButton {
                if(userJoinViewModel.userJoinUiState.value.birthDay == null) {
                    Toast.makeText(context, "데이터를 입력해주세요", Toast.LENGTH_SHORT).show()
                    Log.d("[parksongs]",userJoinViewModel.userJoinUiState.value.toString())
                }else {
                    navHostController.navigate(Screen.GenderInputScreen.route) {
                        Log.i("[parksongs]", userJoinViewModel.userJoinUiState.value.toString())
                    }
                }
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp, 10.dp)
            ) {
                TitleText(text = "생일은 언제인가요?")
                BirthDayInput()
                SubText(text = "프로필에는 생일이 아닌 만 나이가 표시됩니다.")
            }
        }
    }
}