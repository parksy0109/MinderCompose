package com.maro.tindercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.maro.tindercompose.ui.bar.ScreenProgressTopBar
import com.maro.tindercompose.ui.screen.GenderSelectScreen
import com.maro.tindercompose.ui.screen.InterestsSelectScreen
import com.maro.tindercompose.ui.screen.JoinBirthdayScreen
import com.maro.tindercompose.ui.screen.EntranceScreen
import com.maro.tindercompose.ui.screen.MainScreen
import com.maro.tindercompose.ui.screen.OpponentDistanceSelectScreen
import com.maro.tindercompose.ui.screen.PictureAddScreen
import com.maro.tindercompose.ui.screen.RecommendOpponentSelectScreen
import com.maro.tindercompose.ui.screen.RelationsSelectScreen
import com.maro.tindercompose.ui.screen.SchoolInputScreen
import com.maro.tindercompose.ui.screen.Screen
import com.maro.tindercompose.ui.screen.SexualOrientationsSelectScreen
import com.maro.tindercompose.ui.theme.TinderComposeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rememberNavController = rememberNavController()
            var currentScreen by remember { mutableStateOf(0F) }
            TinderComposeTheme {
                Scaffold(
                    topBar = {
                        if(currentScreen >= 1F){
                            ScreenProgressTopBar(currentScreen, 10F)
                        }
                    }
                ) {
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(it),
                        navController = rememberNavController,
                        startDestination = Screen.EntranceScreen.route
                    ) {
                        composable(Screen.EntranceScreen.route) {
                            EntranceScreen(rememberNavController)
                        }
                        composable(Screen.BirthdayInputScreen.route) {
                            currentScreen = 1F
                            JoinBirthdayScreen(rememberNavController)
                        }
                        composable(Screen.GenderInputScreen.route) {
                            currentScreen = 2F
                            GenderSelectScreen(rememberNavController)
                        }
                        composable(Screen.SexualOrientationInputScreen.route) {
                            currentScreen = 3F
                            SexualOrientationsSelectScreen(rememberNavController)
                        }
                        composable(Screen.PreferredPartnerInputScreen.route) {
                            currentScreen = 4F
                            RecommendOpponentSelectScreen(rememberNavController)
                        }
                        composable(Screen.RelationshipInputScreen.route) {
                            currentScreen = 5F
                            RelationsSelectScreen(rememberNavController)
                        }
                        composable(Screen.DistanceInputScreen.route) {
                            currentScreen = 6F
                            OpponentDistanceSelectScreen(rememberNavController)
                        }
                        composable(Screen.SchoolInputScreen.route) {
                            currentScreen = 7F
                            SchoolInputScreen(rememberNavController)
                        }
                        composable(Screen.InterestsInputScreen.route) {
                            currentScreen = 8F
                            InterestsSelectScreen(rememberNavController)
                        }
                        composable(Screen.PhotoAdditionScreen.route) {
                            currentScreen = 9F
                            PictureAddScreen(rememberNavController)
                        }
                        composable(Screen.MainScreen.route) {
                            MainScreen()
                        }
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainTestPreview() {
    TinderComposeTheme {

    }
}