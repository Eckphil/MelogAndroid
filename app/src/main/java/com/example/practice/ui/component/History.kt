package com.example.practice.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

enum class EmotionType{excitement, anticipation, satisfaction, comfortable, emptiness, depression, sadness, anger}

data class DiaryHistoryItem(
    val year: Int,
    val month: Int,
    val day: Int,
    val songTitle: String,
    val artist: String,
    val lyrics: String,
    val emotion: EmotionType // 예: enum class EmotionType { HAPPY, SAD, ANGRY, ... }
)

@Composable
fun History(item: DiaryHistoryItem){
    Card(
        Modifier
            .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .width(380.dp)
            .height(120.dp)
            .background(color = White, shape = RoundedCornerShape(size = 15.dp))
    ){
        Spacer(modifier = Modifier.height(12.dp))
        Row {
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(
                    text = "${item.day}"+"일",
                    style = Typography.bodyMedium,
                    fontSize = 32.sp,
                    color = Lavender02
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "${item.songTitle}"+" - "+"${item.artist}",
                    style = Typography.bodyMedium,
                    fontSize = 32.sp,
                    color = Lavender02
                )
            }
        }
    }
}

@Preview
@Composable
fun HistoryPreview(){
    val exampleItem = DiaryHistoryItem(
        year = 2025, month = 4, day = 7,
        songTitle = "Love Dive",
        artist = "IVE",
        lyrics = "나를 사랑으로 채워줘",
        emotion = EmotionType.excitement
    )

    History(item = exampleItem)
}