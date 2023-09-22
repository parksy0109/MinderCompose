package com.maro.tindercompose.ui.screen

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
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
import com.maro.tindercompose.ui.button.SelectGenderButtons
import com.maro.tindercompose.ui.text.TextWithCheckBox
import com.maro.tindercompose.ui.text.TitleText
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderSelectScreen(
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
                if(userJoinViewModel.userJoinUiState.value.gender.isNotEmpty()) {
                    navHostController.navigate(Screen.SexualOrientationInputScreen.route)
                    Log.d("[parksongs]", userJoinViewModel.userJoinUiState.value.toString())
                }else {
                    Toast.makeText(context, "성별을 선택해주세요.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Scaffold(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(15.dp, 10.dp),
                bottomBar = {
                    TextWithCheckBox(
                        description = "체크하면 프로필에 내 성별이 표시됩니다.",
                        isChecked = userJoinViewModel.userJoinUiState.value.genderDisplayAgreement
                    ) {
                        userJoinViewModel.setGenderDisplayAgreement(!userJoinViewModel.userJoinUiState.value.genderDisplayAgreement)
                    }
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(it),
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    TitleText(text = "성별은 무엇인가요?")
                    SelectGenderButtons(buttonNames = listOf("여성", "남성")) {gender ->
                        userJoinViewModel.setGender(gender)
                    }
                }
            }
        }
    }
}