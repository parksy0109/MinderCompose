package com.maro.tindercompose.ui.screen

sealed class Screen(val route: String) {
    object EntranceScreen: Screen("EntranceScreen")
    object BirthdayInputScreen: Screen("BirthDayInput")
    object GenderInputScreen: Screen("GenderInputScreen")
    object SexualOrientationInputScreen: Screen("SexualOrientationInputScreen")
    object PreferredPartnerInputScreen: Screen("PreferredPartnerInputScreen")
    object RelationshipInputScreen: Screen("RelationshipInputScreen")
    object DistanceInputScreen: Screen("DistanceInputScreen")
    object SchoolInputScreen: Screen("SchoolInputScreen")
    object InterestsInputScreen: Screen("InterestsInputScreen")
    object PhotoAdditionScreen: Screen("PhotoAdditionScreen")
    object MainScreen: Screen("MainScreen")
}