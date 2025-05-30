package com.example.practice

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practice.datastore.TokenManager
import com.example.practice.ui.screens.diary.Calender
import com.example.practice.ui.screens.diary.Diaryloading
import com.example.practice.ui.screens.diary.Diaryview
import com.example.practice.ui.screens.diary.WriteDiary
import com.example.practice.ui.screens.signin.Signin
import com.example.practice.ui.screens.signup.Signup_01
import com.example.practice.ui.screens.signup.Usergenre
import com.example.practice.ui.screens.splash.Signup_00
import com.example.practice.ui.screens.splash.Splash

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
        composable("Diaryview/{diaryId}") { backStackEntry ->
            val diaryId = backStackEntry.arguments?.getString("diaryId")?.toIntOrNull()
            if (diaryId != null) {
                Diaryview(navController = navController, diaryId = diaryId)
            } else {
                // diaryId가 없거나 잘못된 경우 예외 처리
                Text("잘못된 일기 ID입니다.")
            }
        }
        // 더 추가 가능
    }
}

class MyApp : Application(){
    lateinit var tokenManager: TokenManager
        private set

    override fun onCreate() {
        super.onCreate()
        tokenManager = TokenManager(this)
    }
}
