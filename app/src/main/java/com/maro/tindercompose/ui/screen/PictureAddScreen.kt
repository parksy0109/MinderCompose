package com.maro.tindercompose.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.maro.tindercompose.ui.bar.BackArrowTopBar
import com.maro.tindercompose.ui.button.NextButton
import com.maro.tindercompose.ui.card.ImageAddCards
import com.maro.tindercompose.ui.text.SubText
import com.maro.tindercompose.ui.text.TitleText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PictureAddScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            BackArrowTopBar {
                navHostController.popBackStack()
            }
        },
        bottomBar = {
            NextButton {
                navHostController.navigate(Screen.MainScreen.route)
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
                    .padding(20.dp, 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TitleText(text = "최근에 찍은 사진을 추가하세요")
                SubText(text = "프로필 사진을 2장 업로드하세요. 눈길 가는 프로필이 되고 싶다면 4장 이상 추가해보세요.")
                ImageAddCards()
            }
        }
    }
}