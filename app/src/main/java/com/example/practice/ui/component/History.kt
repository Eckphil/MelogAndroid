package com.example.practice.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import com.example.practice.R
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

enum class EmotionType{excitement, anticipation, satisfaction, comfortable, emptiness, depression, sadness, anger}

data class DiaryHistoryItem(
    val diaryId: Int, // ✅ 추가
    val year: Int,
    val month: Int,
    val day: Int,
    val songTitle: String,
    val artist: String,
    val lyrics: String,
    val emotion: EmotionType
)


@Composable
fun History(item: DiaryHistoryItem, onClick: (Int) -> Unit = {}){
    val emotionIcon = when (item.emotion) {
        EmotionType.excitement -> R.drawable.excitement
        EmotionType.anticipation -> R.drawable.anticipation
        EmotionType.satisfaction -> R.drawable.satisfaction
        EmotionType.comfortable -> R.drawable.comfortable
        EmotionType.emptiness -> R.drawable.emptiness
        EmotionType.depression -> R.drawable.depression
        EmotionType.sadness -> R.drawable.sadness
        EmotionType.anger -> R.drawable.anger
    }

    Card(
        Modifier
            .shadow(elevation = 4.dp, spotColor = Color(0x40000000), ambientColor = Color(0x40000000))
            .width(360.dp)
            .height(120.dp)
            .background(color = White, shape = RoundedCornerShape(size = 15.dp))
            .clickable { onClick(item.diaryId) }
    ){
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = "${item.day}"+"일",
                    style = Typography.displayMedium,
                    fontSize = 32.sp,
                    color = Lavender02
                )
                Spacer(modifier = Modifier.height(12.dp))
                Image(
                    painter = painterResource(id = emotionIcon),
                    contentDescription = "Emotion Icon",
                    modifier =  Modifier.size(48.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text(
                    text = item.songTitle +" - "+ item.artist,
                    style = Typography.displayMedium,
                    fontSize = 32.sp,
                    color = Lavender02
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        text = item.lyrics,
                        style = Typography.displayMedium,
                        lineHeight = 25.sp,
                        fontSize = 24.sp,
                        color = Black,
                        modifier = Modifier
                            .padding(bottom = 8.dp, end = 10.dp),
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HistoryPreview(){
    val exampleItem = DiaryHistoryItem(
        diaryId = 1,
        year = 2025, month = 4, day = 7,
        songTitle = "Love Dive",
        artist = "IVE",
        lyrics = "나를 사랑으로 채워줘 2줄이 넘어가는 가사는 어떻게될까? 너무너무 궁금하네",
        emotion = EmotionType.excitement
    )

    History(item = exampleItem)
}