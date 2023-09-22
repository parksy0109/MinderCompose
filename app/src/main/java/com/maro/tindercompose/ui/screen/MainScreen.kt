package com.maro.tindercompose.ui.screen

import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.maro.tindercompose.viewmodel.UserJoinViewModel

@Composable
fun MainScreen(
    userJoinViewModel: UserJoinViewModel = viewModel(LocalContext.current as ComponentActivity)
) {

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "birthDay: " + userJoinViewModel.userJoinUiState.value.birthDay.toString())
        Text(text = "gender: " + userJoinViewModel.userJoinUiState.value.gender)
        Text(text = "genderDisplayAgreement: " + userJoinViewModel.userJoinUiState.value.genderDisplayAgreement.toString())
        Text(text = "sexualOrientations: " + userJoinViewModel.userJoinUiState.value.sexualOrientations.joinToString(","))
        Text(text = "sexualOrientations: " + userJoinViewModel.userJoinUiState.value.sexualOrientationsDisplayAgreement)
        Text(text = "recommendOpponent: " + userJoinViewModel.userJoinUiState.value.recommendOpponent)
        Text(text = "relations: " + userJoinViewModel.userJoinUiState.value.relations)
        Text(text = "opponentDistance: " + userJoinViewModel.userJoinUiState.value.opponentDistance.toString())
        Text(text = "school: " + userJoinViewModel.userJoinUiState.value.school)
        Text(text = "interests: " + userJoinViewModel.userJoinUiState.value.interests.joinToString(","))
        Text(text = "images: " + userJoinViewModel.userJoinUiState.value.images.joinToString(","))
    }

}