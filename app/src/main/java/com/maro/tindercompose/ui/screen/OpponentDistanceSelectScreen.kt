package com.maro.tindercompose.ui.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maro.tindercompose.ui.bar.BackArrowTopBar
import com.maro.tindercompose.ui.button.NextButton
import com.maro.tindercompose.ui.text.SubText
import com.maro.tindercompose.ui.text.TitleText
import com.maro.tindercompose.ui.theme.PrimaryColor
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OpponentDistanceSelectScreen(
    navHostController: NavHostController,
    userJoinViewModel: UserJoinViewModel = viewModel(LocalContext.current as ComponentActivity),
) {
    Scaffold(
        topBar = {
            BackArrowTopBar {
                navHostController.popBackStack()
            }
        },
        bottomBar = {
            NextButton {
                navHostController.navigate(Screen.SchoolInputScreen.route)
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
                    .fillMaxSize(),
                bottomBar = {
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        SubText(text = "설정에서 언제든지 변경할 수 있습니다")
                    }
                }
            ) { paddingValues ->
                Column(
                    Modifier.padding(paddingValues)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(15.dp, 10.dp)
                    ) {
                        TitleText(text = "내가 원하는 상대와의 거리")
                        SubText(text = "슬라이더를 움직여 상대와의 최대 거리를 원하는 대로 설정해 주세요.")
                    }
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(15.dp, 0.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "상대와의 거리", fontWeight = FontWeight.Medium)
                        Text(text = "${userJoinViewModel.userJoinUiState.value.opponentDistance}km")
                    }
                    Slider(
                        modifier = Modifier
                            .padding(15.dp, 0.dp),
                        value = userJoinViewModel.userJoinUiState.value.opponentDistance.toFloat(),
                        onValueChange = { value ->
                            userJoinViewModel.setDistance(value.toInt())
                        },
                        valueRange = 0F..160F,
                        colors = SliderDefaults.colors(
                            thumbColor = PrimaryColor,
                            activeTrackColor = PrimaryColor,
                            inactiveTrackColor = Color(0xFF7D8592)
                        ),
                    )
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp, 10.dp)
                    )
                }
            }
        }
    }
}