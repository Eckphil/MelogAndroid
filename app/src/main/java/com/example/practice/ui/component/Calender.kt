package com.example.practice.ui.component

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.theme.*
import com.example.practice.viewmodel.CalendarViewModel
import com.example.practice.viewmodel.CalendarViewModelFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun CustomCalendar(navController: NavHostController) {
    val context = LocalContext.current
    val factory = remember { CalendarViewModelFactory(context) }
    val calendarViewModel: CalendarViewModel = viewModel(factory = factory)

    val today = LocalDate.now()
    var selectedYear by remember { mutableStateOf(today.year) }
    var selectedMonth by remember { mutableStateOf(today.monthValue) }
    var showDialog by remember { mutableStateOf(false) }

    val diaryEmotions by calendarViewModel.diaryEmotions.collectAsState(initial = emptyMap())
    val diaryIDMap by calendarViewModel.diaryIdMap.collectAsState(initial = emptyMap())

    LaunchedEffect(selectedYear, selectedMonth) {
        calendarViewModel.loadDiaryEmotions(selectedYear, selectedMonth)
    }

    val firstDayOfMonth = LocalDate.of(selectedYear, selectedMonth, 1)
    val daysInMonth = firstDayOfMonth.lengthOfMonth()
    val startDayOfWeek = firstDayOfMonth.dayOfWeek.value % 7
    val totalCells = ((startDayOfWeek + daysInMonth + 6) / 7) * 7
    val dates = (0 until totalCells).map { index ->
        val day = index - startDayOfWeek + 1
        if (day in 1..daysInMonth) LocalDate.of(selectedYear, selectedMonth, day) else null
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "${selectedMonth}월",
            modifier = Modifier.clickable { showDialog = true },
            style = Typography.displayMedium,
            fontSize = 36.sp,
            color = Lavender02
        )

        Spacer(modifier = Modifier.height(40.dp))

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
                            val diaryId = diaryIDMap[date]
                            if (emotionId != null && emotionId in 0..7) {
                                val imageName = getEmotionNameById(emotionId)
                                val imageRes = getDrawableIdByName(imageName)
                                Image(
                                    painter = painterResource(id = imageRes),
                                    contentDescription = "Emotion $emotionId",
                                    modifier = Modifier
                                        .size(48.dp)
                                        .clickable {
                                            navController.navigate("Diaryview/$diaryId")
                                        }
                                )
                            } else {
                                Text(
                                    text = "${date.dayOfMonth}",
                                    fontSize = 20.sp,
                                    color = Lavender03
                                )
                            }
                        }
                    }
                }
            }
        }

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

fun getEmotionNameById(id: Int): String {
    return when (id) {
        1 -> "excitement"
        2 -> "anticipation"
        3 -> "satisfaction"
        4 -> "comfortable"
        5 -> "emptiness"
        6 -> "depression"
        7 -> "sadness"
        8 -> "anger"
        else -> "comfortable"
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
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { currentYear-- }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Previous Year")
                    }
                    Text(
                        text = "${currentYear}년",
                        style = Typography.displayMedium,
                        fontSize = 28.sp,
                        color = Black
                    )
                    IconButton(onClick = { currentYear++ }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "Next Year")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

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
                                maxLines = 1
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
fun YearMonthPickerDialogPreview() {
    YearMonthPickerDialog(2025, {}, { _, _ -> })
}
