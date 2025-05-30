package com.example.practice.ui.screens.diary

import android.widget.Toast
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.practice.ui.component.AppBar
import com.example.practice.ui.component.BottomAppBar
import com.example.practice.ui.component.DiaryHistoryItem
import com.example.practice.ui.component.EmotionType
import com.example.practice.ui.component.History
import com.example.practice.ui.component.LineInput
import com.example.practice.ui.component.TwoButtonAppBar
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender01
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.viewmodel.DeleteDiaryViewModel
import com.example.practice.viewmodel.DeleteDiaryViewModelFactory
import com.example.practice.viewmodel.DiaryDetailViewModel
import com.example.practice.viewmodel.DiaryDetailViewModelFactory
import com.example.practice.viewmodel.UpdateDiaryViewModel
import com.example.practice.viewmodel.UpdateDiaryViewModelFactory

@Composable
fun Diaryview(
    navController: NavController,
    diaryId: Int
) {
    val context = LocalContext.current
    val viewModel: DiaryDetailViewModel = viewModel(factory = DiaryDetailViewModelFactory(context))

    val deleteFactory = remember { DeleteDiaryViewModelFactory(context) }
    val deleteViewModel: DeleteDiaryViewModel = viewModel(factory = deleteFactory)
    val deleteSuccess by deleteViewModel.deleteSuccess.collectAsState()

    val diaryItem by viewModel.diaryItem.collectAsState()
    val content by viewModel.content.collectAsState()

    // Composable이 시작되자마자 일기 불러오기
    LaunchedEffect(diaryId) {
        viewModel.loadDiaryById(diaryId)
    }
    LaunchedEffect(deleteSuccess) {
        if (deleteSuccess) {
            Toast.makeText(context, "일기가 삭제되었습니다.", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
        }
    }

    Scaffold(
        topBar = {
            TwoButtonAppBar(
                title = "일기 확인",
                text1 = "삭제",
                text2 = "수정",
                onBackClick = { navController.popBackStack() },
                onAction1Click = { deleteViewModel.deleteDiary(diaryId) },
                onAction2Click = { /* 수정 구현 */ }
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
                    text = "${diaryItem?.year ?: ""}년 ${diaryItem?.month ?: ""}월 ${diaryItem?.day ?: ""}일",
                    style = Typography.displayMedium,
                    fontSize = 24.sp
                )
                Spacer(modifier = Modifier.height(28.dp))
                diaryItem?.let { History(it) }
                Spacer(modifier = Modifier.height(40.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = content,
                        style = Typography.displayMedium,
                        fontSize = 20.sp,
                        color = Lavender02,
                        lineHeight = 28.sp
                    )
                }
            }
        },
        bottomBar = { BottomAppBar() }
    )
}
