package com.maro.tindercompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.maro.tindercompose.model.UserJoinUiState
import java.time.LocalDate

class UserJoinViewModel : ViewModel() {

    var userJoinUiState = mutableStateOf(
        UserJoinUiState(
            birthDay = null, // 기본값으로 현재 날짜 설정
            gender = "",
            genderDisplayAgreement = false,
            sexualOrientations = emptyList(),
            sexualOrientationsDisplayAgreement = false,
            recommendOpponent = "",
            relations = "",
            opponentDistance = 80,
            school = "",
            interests = emptyList(),
            images = emptyList()
        )
    )

    fun updateUserJoinUiState(userJoinUiState: UserJoinUiState) {
        this.userJoinUiState.value = userJoinUiState
    }

    fun setBirthDay(localDate: LocalDate) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            birthDay = localDate
        )
    }

    fun setGender(gender: String) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            gender = gender
        )
    }

    fun setGenderDisplayAgreement(isChecked: Boolean) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            genderDisplayAgreement = isChecked
        )
    }

    fun setSexualOrientations(sexualOrientations: List<String>) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            sexualOrientations = sexualOrientations
        )
    }

    fun setSexualOrientationsDisplayAgreement(isChecked: Boolean) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            sexualOrientationsDisplayAgreement = isChecked
        )
    }

    fun setRecommendOpponent(recommendOpponent: String) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            recommendOpponent = recommendOpponent
        )
    }

    fun setRelations(relations: String) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            relations = relations
        )
    }

    fun setDistance(distance: Int) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            opponentDistance = distance
        )
    }

    fun setSchool(school: String) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            school = school
        )
    }

    fun setInterests(interests: List<String>) {
        this.userJoinUiState.value = this.userJoinUiState.value.copy(
            interests = interests
        )
    }


}