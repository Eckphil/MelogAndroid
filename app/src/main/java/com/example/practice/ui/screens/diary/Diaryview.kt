package com.example.practice.ui.screens.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.component.AppBar
import com.example.practice.ui.component.BottomAppBar
import com.example.practice.ui.component.DiaryHistoryItem
import com.example.practice.ui.component.EmotionType
import com.example.practice.ui.component.History
import com.example.practice.ui.component.LineInput
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender01
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography

@Preview
@Composable
fun Diaryview(){
    Scaffold(
        topBar = {AppBar("일기 확인", "수정", {}, {})},
        content = { innerPadding->
            Column (
                modifier = Modifier
                    .padding(innerPadding)
                    .background(Lavender01)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "2024.11.14 (일)",
                    style = Typography.displayMedium,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(28.dp))
                val exampleItem = DiaryHistoryItem(
                    year = 2025, month = 4, day = 7,
                    songTitle = "녹아내려요",
                    artist = "Day6",
                    lyrics = "너의 그 미소가" + "\n" + "다시 버텨낼 수 있게 해줘요",
                    emotion = EmotionType.excitement
                )
                History(item = exampleItem)
                Spacer(modifier = Modifier.height(40.dp))
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                ){
                    Text(
                        text = "일기 내용은 추후 DB에서 뽑아올거여서 아직 형태를 잡아놓진 않을게요. " +
                                "줄바꿈이 어떻게되는지 한번 궁금해서 최대한 쭉쭉 길게 뽑아서 써보는중인데" +
                                "어떻게 나오려나? 궁금하네요 한번 이거를 보면서 수정을 해봐야겠죠? 열심히할게요" +
                                "ㅠㅠ 열심히하겠습니다 사장님 돈주세요 사장님",
                        style = Typography.displayMedium,
                        fontSize = 24.sp,
                        color = Lavender02,
                        lineHeight = 24.sp
                    )
                }
            }
        },
        bottomBar = { BottomAppBar() }
    )
}