package com.maro.tindercompose.model

import java.time.LocalDate

data class UserJoinUiState(
    var birthDay: LocalDate?,
    var gender: String,
    var genderDisplayAgreement: Boolean,
    var sexualOrientations: List<String>,
    var sexualOrientationsDisplayAgreement: Boolean,
    var recommendOpponent: String,
    var relations: String,
    var opponentDistance: Int,
    var school: String,
    var interests: List<String>,
    var images: List<String>
)