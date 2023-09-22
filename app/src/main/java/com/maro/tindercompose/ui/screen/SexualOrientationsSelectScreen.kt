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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.maro.tindercompose.ui.bar.BackArrowTopBar
import com.maro.tindercompose.ui.button.NextButton
import com.maro.tindercompose.ui.list.ItemCheckList
import com.maro.tindercompose.ui.text.SubText
import com.maro.tindercompose.ui.text.TextWithCheckBox
import com.maro.tindercompose.ui.text.TitleText
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SexualOrientationsSelectScreen(
    navHostController: NavHostController,
    userJoinViewModel: UserJoinViewModel = viewModel(LocalContext.current as ComponentActivity),
    context: Context = LocalContext.current
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(), topBar = {
            BackArrowTopBar {
                navHostController.popBackStack()
            }
        },
        bottomBar = {
            NextButton {
                if(userJoinViewModel.userJoinUiState.value.sexualOrientations.isNotEmpty()) {
                    navHostController.navigate(Screen.PreferredPartnerInputScreen.route)
                }else {
                    Toast.makeText(context, "성적 지향을 한가지이상 선택해주세요", Toast.LENGTH_SHORT).show()
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
                    .fillMaxSize(),
                bottomBar = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Divider()
                        TextWithCheckBox(
                            description = "체크하면 프로필에 내 성적 지향이 표시됩니다",
                            isChecked = userJoinViewModel.userJoinUiState.value.sexualOrientationsDisplayAgreement
                        ) {
                            userJoinViewModel.setSexualOrientationsDisplayAgreement(!userJoinViewModel.userJoinUiState.value.sexualOrientationsDisplayAgreement)
                        }
                    }
                }
            ) { paddingValues ->
                Column(
                    modifier = Modifier
                        .padding(paddingValues)
                        .fillMaxSize()
                        .wrapContentHeight(),
                    verticalArrangement = Arrangement.spacedBy(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp, 10.dp)
                            .wrapContentHeight(),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        TitleText(text = "성적 지향은 어떻게\n되시나요?")
                        SubText(text = "최대 3개까지 선택할 수 있습니다.")
                    }
                    Divider()
                    ItemCheckList(
                        listOf(
                            "이성애",
                            "게이",
                            "레즈비언",
                            "바이섹슈얼",
                            "에이섹슈얼",
                            "데미섹슈얼",
                            "펜섹슈얼",
                        )
                    ) { checkedItems ->
                        userJoinViewModel.setSexualOrientations(checkedItems)
                    }
                }
            }

        }
    }
}