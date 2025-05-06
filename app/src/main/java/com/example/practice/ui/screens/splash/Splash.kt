package com.example.practice.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun Splash(navController: NavHostController){
    LaunchedEffect(true) {
        delay(3000) // 3초 대기
        navController.navigate("Signup_00") {
            popUpTo("Splash") { inclusive = true } // 스택에서 Splash 제거
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center,
    ){
        Image(
            painter = painterResource(id = R.drawable.melog),
            contentDescription = "Melog Logo",
            modifier = Modifier
                .width(283.16547.dp)
                .height(160.dp)
        )
    }
}