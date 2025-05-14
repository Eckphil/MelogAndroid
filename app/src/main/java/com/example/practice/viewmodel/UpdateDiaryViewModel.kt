package com.example.practice.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import com.example.practice.api.DiaryUpdateRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UpdateDiaryViewModel(private val context: Context) : ViewModel() {

    private val _updateSuccess = MutableStateFlow(false)
    val updateSuccess: StateFlow<Boolean> = _updateSuccess

    fun updateDiary(diaryId: Int, newContent: String) {
        viewModelScope.launch {
            try {
                val api = ApiClient.getApi(context)
                val response = api.updateDiary(diaryId, DiaryUpdateRequest(newContent))
                _updateSuccess.value = response.isSuccessful
            } catch (e: Exception) {
                e.printStackTrace()
                _updateSuccess.value = false
            }
        }
    }
}

class UpdateDiaryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(UpdateDiaryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return UpdateDiaryViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
