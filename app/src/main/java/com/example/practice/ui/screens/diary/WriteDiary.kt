package com.example.practice.ui.screens.diary

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.practice.ui.component.AppBar
import com.example.practice.ui.component.BottomAppBar
import com.example.practice.ui.theme.*
import com.example.practice.viewmodel.WriteDiaryViewModel
import com.example.practice.viewmodel.WriteDiaryViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun WriteDiary(navController: NavHostController) {
    val context = LocalContext.current
    val factory = remember { WriteDiaryViewModelFactory(context) }
    val viewModel: WriteDiaryViewModel = viewModel(factory = factory)

    val today = LocalDate.now()
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd (E)")
    val formattedDate = today.format(formatter)

    var text by remember { mutableStateOf("오늘 하루를 기록해보세요!") }

    // 성공 시 뒤로 가기 처리
    val saveSuccess by viewModel.saveSuccess.collectAsState()

    LaunchedEffect(saveSuccess) {
        if (saveSuccess) {
            Toast.makeText(context, "일기가 저장되었습니다.", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
        }
    }

    Scaffold(
        topBar = {
            AppBar(
                title = "일기 작성",
                text = "저장",
                onBackClick = { navController.popBackStack() },
                onActionClick = {
                    if (text.isNotBlank()) {
                        viewModel.saveDiary(text)
                    } else {
                        Toast.makeText(context, "내용을 입력해주세요.", Toast.LENGTH_SHORT).show()
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .background(Lavender01)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = formattedDate,
                    style = Typography.displayMedium,
                    fontSize = 24.sp
                )
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    HorizontalDivider(thickness = 3.dp, color = Lavender04)
                }

                BasicTextField(
                    value = text,
                    onValueChange = { text = it },
                    textStyle = Typography.displayMedium.copy(
                        color = if (text == "오늘 하루를 기록해보세요!") Grey else Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.Start)
                        .padding(horizontal = 16.dp)
                        .weight(1f)
                )
            }
        },
        bottomBar = { BottomAppBar() }
    )
}
