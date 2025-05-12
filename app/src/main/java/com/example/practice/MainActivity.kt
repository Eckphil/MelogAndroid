package com.example.practice

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.screens.LoginTestScreen
import com.example.practice.ui.screens.diary.Calender
import com.example.practice.ui.screens.diary.Diaryloading
import com.example.practice.ui.screens.diary.Diaryview
import com.example.practice.ui.screens.diary.WriteDiary
import com.example.practice.ui.screens.signin.Signin
import com.example.practice.ui.screens.signup.Signup_01
import com.example.practice.ui.screens.signup.Usergenre
import com.example.practice.ui.screens.splash.Signup_00
import com.example.practice.ui.screens.splash.Splash
import com.example.practice.ui.theme.PracticeTheme
import com.example.practice.ui.theme.Typography
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainApp()
        }
    }
}

@Composable
fun MainApp(modifier: Modifier = Modifier){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Splash") {
        composable("Splash"){ Splash(navController)}
        composable("Signup_00"){ Signup_00(navController)}
        composable("Signup_01") { Signup_01(navController) }
        composable("Usergenre"){ Usergenre(navController)}
        composable("Signin") { Signin(navController) }
        composable("Calender"){ Calender(navController)}
        composable("WriteDiary") { WriteDiary(navController)}
        composable("Diaryloading") { Diaryloading(navController)}
        composable("Diaryview"){Diaryview(navController)}
        // 더 추가 가능
    }
}

@HiltAndroidApp
class MyApp : Application(){

}
