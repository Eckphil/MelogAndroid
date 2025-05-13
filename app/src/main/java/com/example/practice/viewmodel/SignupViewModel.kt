package com.example.practice.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practice.api.ApiClient
import com.example.practice.api.UserCreateRequest
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import androidx.compose.runtime.*

class SignupViewModel(private val context: Context) : ViewModel() {
    var userId by mutableStateOf("")
    var password by mutableStateOf("")
    var passwordCheck by mutableStateOf("")
    var nickname by mutableStateOf("")
    var phone by mutableStateOf("")
    var errorMessage by mutableStateOf<String?>(null)

    fun onSignup(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        if (password != passwordCheck) {
            onFailure("비밀번호가 일치하지 않습니다.")
            return
        }

        viewModelScope.launch {
            try {
                val api = ApiClient.getApi(context)
                val request = UserCreateRequest(
                    user_id = userId,
                    password = password,
                    nickname = nickname,
                    phone = if (phone.isBlank()) null else phone
                )

                val response = api.registerUser(request)

                if (response.isSuccessful) {
                    onSuccess()
                } else {
                    onFailure("회원가입 실패: ${response.code()}")
                }
            } catch (e: IOException) {
                onFailure("네트워크 오류가 발생했습니다.")
            } catch (e: HttpException) {
                onFailure("서버 오류가 발생했습니다.")
            } catch (e: Exception) {
                onFailure("오류: ${e.localizedMessage}")
            }
        }
    }
}

class SignupViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignupViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SignupViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
