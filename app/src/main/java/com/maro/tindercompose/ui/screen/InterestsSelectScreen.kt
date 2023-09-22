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
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maro.tindercompose.ui.bar.BackArrowTopBar
import com.maro.tindercompose.ui.button.NextButton
import com.maro.tindercompose.ui.chips.Chips
import com.maro.tindercompose.ui.text.SubText
import com.maro.tindercompose.ui.text.TitleText
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InterestsSelectScreen(
    navHostController: NavHostController,
    userJoinViewModel: UserJoinViewModel = viewModel(LocalContext.current as ComponentActivity),
    context: Context = LocalContext.current
) {
    var nextButtonSize by remember { mutableStateOf(1) }

    Scaffold(
        topBar = {
            BackArrowTopBar {
                navHostController.popBackStack()
            }
        },
        bottomBar = {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Divider()
                NextButton(text = "다음 $nextButtonSize/5") {
                    if (userJoinViewModel.userJoinUiState.value.interests.isNotEmpty()) {
                        navHostController.navigate(Screen.PhotoAdditionScreen.route)
                    } else {
                        Toast.makeText(context, "관심사를 한개이상 선택해주세요.", Toast.LENGTH_SHORT).show()
                    }
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
                TitleText(text = "요즘 푹 빠진 관심사는 무엇인가요?")
                SubText(text = "나를 나타내는 관심사, 이제 프로필에 공유해보세요.")
            }
            Divider()
            Chips { interests ->
                userJoinViewModel.setInterests(interests)
                nextButtonSize = interests.size
            }
        }
    }
}