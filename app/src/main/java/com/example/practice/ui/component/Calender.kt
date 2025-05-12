package com.example.practice.ui.component

import CalendarViewModel
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice.R
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender03
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CustomCalendar(viewModel: CalendarViewModel = hiltViewModel()) {
    val today = LocalDate.now()
    var selectedYear by remember { mutableStateOf(today.year) }
    var selectedMonth by remember { mutableStateOf(today.monthValue) }
    val diaryEmotions = viewModel.diaryEmotions

    LaunchedEffect(selectedYear, selectedMonth) {
        viewModel.loadDiaryEmotions(selectedYear, selectedMonth)
    }

    // 달력 날짜 생성
    val firstDayOfMonth = LocalDate.of(selectedYear, selectedMonth, 1)
    val daysInMonth = firstDayOfMonth.lengthOfMonth()
    val startDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
    val totalCells = ((startDayOfWeek + daysInMonth + 6) / 7) * 7
    val dates = (0 until totalCells).map { index ->
        val day = index - startDayOfWeek + 1
        if (day in 1..daysInMonth) LocalDate.of(selectedYear, selectedMonth, day) else null
    }

    Column(modifier = Modifier.padding(16.dp)) {
        // 연월 선택 및 요일 표시 생략 ...

        dates.chunked(7).forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { date ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        if (date != null) {
                            val emotionId = diaryEmotions[date]
                            if (emotionId != null && emotionId in 0..7) {
                                val imageRes = getDrawableIdByName("emotion_$emotionId")
                                Image(
                                    painter = painterResource(id = imageRes),
                                    contentDescription = "Emotion $emotionId",
                                    modifier = Modifier.size(32.dp)
                                )
                            } else {
                                Text(
                                    text = "${date.dayOfMonth}",
                                    style = Typography.displayMedium,
                                    fontSize = 20.sp,
                                    color = Color.Black
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getDrawableIdByName(name: String): Int {
    val context = LocalContext.current
    return context.resources.getIdentifier(name, "drawable", context.packageName)
}




@Composable
fun YearMonthPickerDialog(
    initialYear: Int,
    onDismiss: () -> Unit,
    onMonthSelected: (year: Int, month: Int) -> Unit
) {
    var currentYear by remember { mutableStateOf(initialYear) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(15.dp),
            color = Color.White,
            modifier = Modifier
                .height(300.dp)
                .width(380.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                // 연도 선택
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { currentYear-- }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Previous Year"
                        )
                    }

                    Text(
                        text = "$currentYear"+"년",
                        style = Typography.displayMedium,
                        fontSize = 28.sp,
                        modifier = Modifier.align(Alignment.CenterVertically),
                        color = Black
                    )

                    IconButton(onClick = { currentYear++ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Next Year"
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                // 월 선택 (4x3)
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.height(200.dp)
                ) {
                    items(12) { index ->
                        val month = index + 1
                        TextButton(
                            onClick = {
                                onMonthSelected(currentYear, month)
                                onDismiss()
                            },
                            modifier = Modifier
                                .height(48.dp)
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "${month}월",
                                style = Typography.displayMedium,
                                fontSize = 20.sp,
                                color = Lavender02,
                                maxLines = 1, // ✅ 한 줄로 제한
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun getEmojiResId(emotionId: Int): Int {
    return when (emotionId) {
        0 -> R.drawable.excitement
        1 -> R.drawable.anticipation
        2 -> R.drawable.satisfaction
        3 -> R.drawable.comfortable
        4 -> R.drawable.emptiness
        5 -> R.drawable.depression
        6 -> R.drawable.sadness
        7 -> R.drawable.anger
        else -> R.drawable.comfortable
    }
}

@Preview(showBackground = true)
@Composable
fun CustomCalenderPreview(){
    CustomCalendar()
}

@Preview(showBackground = true)
@Composable
fun YearMonthPickerDialogPreview(){
    YearMonthPickerDialog(2025,{}, { year, month -> })
}