package com.example.practice.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DeleteDiaryViewModel(private val context: Context) : ViewModel() {

    private val _deleteSuccess = MutableStateFlow(false)
    val deleteSuccess: StateFlow<Boolean> = _deleteSuccess

    fun deleteDiary(diaryId: Int) {
        viewModelScope.launch {
            try {
                val api = ApiClient.getApi(context)
                val response = api.deleteDiary(diaryId)
                _deleteSuccess.value = response.isSuccessful
            } catch (e: Exception) {
                e.printStackTrace()
                _deleteSuccess.value = false
            }
        }
    }
}

class DeleteDiaryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DeleteDiaryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DeleteDiaryViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
