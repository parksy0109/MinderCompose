package com.maro.tindercompose.ui.screen

import android.content.Context
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
import com.maro.tindercompose.ui.card.ImageTextCards
import com.maro.tindercompose.ui.text.SubText
import com.maro.tindercompose.ui.text.TitleText
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelationsSelectScreen(
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
                if(userJoinViewModel.userJoinUiState.value.relations.isNotEmpty()) {
                    navHostController.navigate(Screen.DistanceInputScreen.route)
                }else {
                    Toast.makeText(context, "본인이 찾고 있는 관계를 하나 선택해주세요.", Toast.LENGTH_SHORT).show()
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
                    .padding(15.dp, 10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                TitleText(text = "지금 내가 찾는\n관계는...")
                SubText(text = "지금 답하고 나와 맞는 사람을 찾아보세요!")
                ImageTextCards { relations ->
                    userJoinViewModel.setRelations(relations)
                }
            }
        }
    }

}