package com.example.practice.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import com.example.practice.ui.component.DiaryHistoryItem
import com.example.practice.ui.component.EmotionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class DiaryHistoryViewModel(private val context: Context) : ViewModel() {

    private val _latestDiaryItem = MutableStateFlow<DiaryHistoryItem?>(null)
    val latestDiaryItem: StateFlow<DiaryHistoryItem?> = _latestDiaryItem

    fun loadLatestDiary() {
        viewModelScope.launch {
            val api = ApiClient.getApi(context)
            val response = api.getDiaries()
            if (response.isSuccessful) {
                val diaryList = response.body()?.sortedByDescending {
                    LocalDate.parse(it.created_at, DateTimeFormatter.ISO_DATE_TIME)
                } ?: emptyList()

                val latest = diaryList.firstOrNull()
                latest?.let {
                    val emotion = convertEmotionId(it.emotiontype_id ?: 3)
                    val song = it.recommended_songs.firstOrNull()
                    val date = LocalDate.parse(it.created_at, DateTimeFormatter.ISO_DATE_TIME)

                    _latestDiaryItem.value = DiaryHistoryItem(
                        diaryId = it.id,
                        year = date.year,
                        month = date.monthValue,
                        day = date.dayOfMonth,
                        songTitle = song?.song_name ?: "제목 없음",
                        artist = song?.artist?.joinToString(", ") ?: "아티스트 없음",
                        lyrics = song?.best_lyric ?: "",
                        emotion = emotion
                    )
                }
            }
        }
    }

    private fun convertEmotionId(id: Int): EmotionType {
        return when (id) {
            1 -> EmotionType.excitement
            2 -> EmotionType.anticipation
            3 -> EmotionType.satisfaction
            4 -> EmotionType.comfortable
            5 -> EmotionType.emptiness
            6 -> EmotionType.depression
            7 -> EmotionType.sadness
            8 -> EmotionType.anger
            else -> EmotionType.comfortable
        }
    }
}

class DiaryHistoryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryHistoryViewModel::class.java)) {
            return DiaryHistoryViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
