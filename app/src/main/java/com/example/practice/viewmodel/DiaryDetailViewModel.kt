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

class DiaryDetailViewModel(private val context: Context) : ViewModel() {

    private val _diaryItem = MutableStateFlow<DiaryHistoryItem?>(null)
    val diaryItem: StateFlow<DiaryHistoryItem?> = _diaryItem

    private val _content = MutableStateFlow("")
    val content: StateFlow<String> = _content

    fun loadDiaryById(diaryId: Int) {
        viewModelScope.launch {
            try {
                val api = ApiClient.getApi(context)
                val response = api.getDiary(diaryId)
                if (response.isSuccessful) {
                    val diary = response.body()
                    diary?.let {
                        val date = LocalDate.parse(it.created_at, DateTimeFormatter.ISO_DATE_TIME)
                        _diaryItem.value = DiaryHistoryItem(
                            diaryId = it.id,
                            year = date.year,
                            month = date.monthValue,
                            day = date.dayOfMonth,
                            songTitle = it.recommended_songs.firstOrNull()?.song_name ?: "제목 없음",
                            artist = it.recommended_songs.firstOrNull()?.artist?.joinToString(", ") ?: "아티스트 없음",
                            lyrics = it.recommended_songs.firstOrNull()?.best_lyric ?: "",
                            emotion = emotionIdToEnum(it.emotiontype_id ?: 3) // 기본값 comfortable
                        )
                        _content.value = it.content
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun emotionIdToEnum(id: Int): EmotionType {
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

class DiaryDetailViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiaryDetailViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiaryDetailViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
