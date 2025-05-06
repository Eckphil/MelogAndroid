package com.example.practice.ui.screens.diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

@Composable

fun Diaryloading(navController: NavHostController){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White),
        contentAlignment = Alignment.Center,
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.melog),
                contentDescription = "Melog Logo",
                modifier = Modifier
                    .width(283.16547.dp)
                    .height(160.dp)
            )
            Spacer(modifier = Modifier.height(60.dp))
            Text(
                text = "일기 분석중...",
                style = Typography.displayMedium,
                fontSize = 32.sp,
                color = Lavender04
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(
                text = "지금 일기를 분석하고 있어요",
                style = Typography.displayMedium,
                fontSize = 24.sp,
                color = Lavender04
            )
            Text(
                text = "잠시만 기다려주세요",
                style = Typography.displayMedium,
                fontSize = 24.sp,
                color = Lavender04
            )
        }
    }
}