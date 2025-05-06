package com.example.practice.ui.screens.diary

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.component.CustomCalendar
import com.example.practice.ui.component.DiaryHistoryItem
import com.example.practice.ui.component.EmotionType
import com.example.practice.ui.component.History
import com.example.practice.ui.theme.Lavender01
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender03
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

@Composable
fun Calender(navController: NavHostController){
    Scaffold(
        content = { innerPadding ->
            Column (
                modifier = Modifier
                    .background(Lavender01)
                    .fillMaxSize()
                    .padding((innerPadding)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CustomCalendar()
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = "최근 작성한 일기",
                    style = Typography.displayMedium,
                    fontSize = 28.sp,
                    color = Lavender04,
                    modifier = Modifier
                        .fillMaxWidth() // 전체 너비를 채운 다음
                        .align(Alignment.Start) // Column 안에서 왼쪽 정렬
                        .padding(start = 16.dp)
                )
                Spacer(modifier = Modifier.height(20.dp))
                val exampleItem = DiaryHistoryItem(
                    year = 2025, month = 4, day = 7,
                    songTitle = "녹아내려요",
                    artist = "Day6",
                    lyrics = "너의 그 미소가" + "\n" + "다시 버텨낼 수 있게 해줘요",
                    emotion = EmotionType.excitement
                )

                History(item = exampleItem)
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("WriteDiary") },
                containerColor = White, // 원하는 색상
                shape = CircleShape,
                modifier = Modifier
                    .size(72.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.write),
                    contentDescription = "Write Diary",
                    modifier = Modifier
                        .size(24.dp)
                )
            }
        },
        bottomBar = { com.example.practice.ui.component.BottomAppBar() }
    )
}