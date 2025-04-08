package com.example.practice.ui.component

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender03
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import java.time.LocalDate
import java.time.YearMonth

@Composable
fun CustomCalendar() {
    val today = LocalDate.now()
    var selectedYear by remember { mutableStateOf(today.year) }
    var selectedMonth by remember { mutableStateOf(today.monthValue) }
    var showDialog by remember { mutableStateOf(false) }

    val firstDayOfMonth = LocalDate.of(selectedYear, selectedMonth, 1)
    val lastDayOfMonth = firstDayOfMonth.withDayOfMonth(firstDayOfMonth.lengthOfMonth())
    val startDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
    val daysInMonth = lastDayOfMonth.dayOfMonth

    val totalCells = ((startDayOfWeek + daysInMonth + 6) / 7) * 7 // 주 단위로 정렬
    val dates = (0 until totalCells).map { index ->
        val day = index - startDayOfWeek + 1
        if (day in 1..daysInMonth) day else null
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // 연월 텍스트 (클릭 시 다이얼로그 오픈)
        Text(
            text = "${selectedMonth}월",
            modifier = Modifier
                .clickable { showDialog = true },
            style = Typography.displayMedium,
            fontSize = 36.sp,
            color = Lavender02,
        )

        Spacer(modifier = Modifier.height(40.dp))

        // 요일 헤더
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            listOf("일", "월", "화", "수", "목", "금", "토").forEach { day ->
                Text(
                    text = day,
                    modifier = Modifier.weight(1f),
                    style = Typography.displayMedium,
                    fontSize = 20.sp,
                    color = Lavender03,
                    textAlign = TextAlign.Center
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        // 날짜 출력
        dates.chunked(7).forEach { week ->
            Row(modifier = Modifier.fillMaxWidth()) {
                week.forEach { day ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f),
                        contentAlignment = Alignment.Center
                    ) {
                        if (day != null) {
                            val isToday = today.year == selectedYear && today.monthValue == selectedMonth && today.dayOfMonth == day
                            Box(
                                modifier = Modifier
                                    .size(48.dp)
                                    .clip(CircleShape)
                                    .background(if (isToday) Lavender04 else Color.Transparent),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = "$day",
                                    textAlign = TextAlign.Center,
                                    color = if (isToday) Color.White else Color.Black,
                                    style = Typography.displayMedium,
                                    fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }
        }

        // 연월 선택 다이얼로그
        if (showDialog) {
            YearMonthPickerDialog(
                initialYear = selectedYear,
                onDismiss = { showDialog = false },
                onMonthSelected = { year, month ->
                    selectedYear = year
                    selectedMonth = month
                    showDialog = false
                }
            )
        }
    }
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