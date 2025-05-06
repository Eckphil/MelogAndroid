package com.example.practice.ui.screens.diary

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.navigation.NavHostController
import com.example.practice.ui.component.AppBar
import com.example.practice.ui.component.BottomAppBar
import com.example.practice.ui.component.LineInput
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender01
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import java.time.LocalDate
import java.time.format.DateTimeFormatter


@Composable
fun WriteDiary(navController: NavHostController){
    val input = "오늘 하루를 기록해보세요!"
    var text by remember { mutableStateOf(input)}
    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)") // 원하는 형식 지정
    val formattedDate = today.format(formatter)

    Scaffold(
        topBar = {AppBar(
            title = "일기 작성",
            text = "저장",
            onBackClick = {navController.popBackStack()},
            onActionClick = {}
        )
                 },
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
                    text = formattedDate,
                    style = Typography.displayMedium,
                    fontSize = 24.sp
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    HorizontalDivider(thickness = 3.dp, color = Lavender04) // 구분선 추가
                }
                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    textStyle = Typography.displayMedium.copy(
                        color = if (text == input) Grey else Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth() // 전체 너비 확보
                        .align(Alignment.Start) // 좌측 정렬
                        .padding(horizontal = 16.dp) // 여백은 선택
                        .weight(1f)
                )
            }
        },
        bottomBar = { BottomAppBar() }
    )
}