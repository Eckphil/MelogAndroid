package com.example.practice.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import com.example.practice.api.DiaryCreateRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class WriteDiaryViewModel(private val context: Context) : ViewModel() {
    private val _saveSuccess = MutableStateFlow(false)
    val saveSuccess: StateFlow<Boolean> = _saveSuccess

    fun saveDiary(content: String) {
        viewModelScope.launch {
            try {
                val api = ApiClient.getApi(context)
                val response = api.createDiaryMain(DiaryCreateRequest(content))
                if (response.isSuccessful && response.body() != null) {
                    _saveSuccess.value = true
                } else {
                    _saveSuccess.value = false
                }
            } catch (e: IOException) {
                e.printStackTrace()
                _saveSuccess.value = false
            } catch (e: HttpException) {
                e.printStackTrace()
                _saveSuccess.value = false
            } catch (e: Exception) {
                e.printStackTrace()
                _saveSuccess.value = false
            }
        }
    }
}

class WriteDiaryViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WriteDiaryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WriteDiaryViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
