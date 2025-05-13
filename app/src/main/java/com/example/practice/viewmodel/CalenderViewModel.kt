package com.example.practice.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import com.example.practice.ui.component.EmotionType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CalendarViewModel(private val context: Context) : ViewModel() {

    private val _diaryEmotions = MutableStateFlow<Map<LocalDate, Int>>(emptyMap())
    val diaryEmotions: StateFlow<Map<LocalDate, Int>> = _diaryEmotions

    private val _diaryIdMap = MutableStateFlow<Map<LocalDate, Int>>(emptyMap())
    val diaryIdMap: StateFlow<Map<LocalDate, Int>> = _diaryIdMap

    fun loadDiaryEmotions(year: Int, month: Int) {
        viewModelScope.launch {
            try {
                val api = ApiClient.getApi(context)
                val response = api.getDiaryByDate(year, month)
                if (response.isSuccessful) {
                    val diaries = response.body() ?: emptyList()
                    val formatter = DateTimeFormatter.ISO_DATE_TIME

                    val emotionMap = diaries
                        .filter { it.created_at != null && it.emotiontype_id != null }
                        .associate { diary ->
                            val date = LocalDate.parse(diary.created_at, formatter)
                            date to diary.emotiontype_id!!
                        }

                    val idMap = diaries
                        .filter { it.created_at != null }
                        .associate { diary ->
                            val date = LocalDate.parse(diary.created_at, formatter)
                            date to diary.id
                        }

                    _diaryEmotions.value = emotionMap
                    _diaryIdMap.value = idMap
                } else {
                    _diaryEmotions.value = emptyMap()
                    _diaryIdMap.value = emptyMap()
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _diaryEmotions.value = emptyMap()
                _diaryIdMap.value = emptyMap()
            }
        }
    }
}

class CalendarViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CalendarViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
