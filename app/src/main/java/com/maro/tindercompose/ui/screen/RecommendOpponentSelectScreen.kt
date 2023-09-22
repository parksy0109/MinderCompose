package com.maro.tindercompose.ui.screen

import android.content.Context
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maro.tindercompose.ui.bar.BackArrowTopBar
import com.maro.tindercompose.ui.button.NextButton
import com.maro.tindercompose.ui.button.SelectGenderButtons
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecommendOpponentSelectScreen(
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
                if(userJoinViewModel.userJoinUiState.value.recommendOpponent.isNotEmpty()) {
                    navHostController.navigate(Screen.RelationshipInputScreen.route)
                }else {
                    Toast.makeText(context, "추천 받고픈 상대를 골라주세요.", Toast.LENGTH_SHORT).show()
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
                    .fillMaxSize()
                    .padding(15.dp, 10.dp)
            ) {
                Text(
                    modifier = Modifier
                        .padding(0.dp, 0.dp, 0.dp, 20.dp),
                    text = "Minder에서 추천 받고픈 상대는 누구인가요?",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black,
                    softWrap = true
                )
                SelectGenderButtons(buttonNames = listOf("여성", "남성", "모두")) { recommendOpponent ->
                    userJoinViewModel.setRecommendOpponent(recommendOpponent)
                }
            }
        }
    }
}