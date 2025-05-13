package com.example.practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.practice.api.MelogApi
import com.example.practice.api.UserLoginRequest
import com.example.practice.datastore.TokenManager
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import androidx.compose.runtime.*

class LoginViewModel(
    private val tokenManager: TokenManager,
    private val apiService: MelogApi
) : ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")
    var loginMessage by mutableStateOf("")

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun login(onSuccess: () -> Unit, onFailure: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = apiService.loginUser(UserLoginRequest(email, password))
                if (response.isSuccessful) {
                    loginMessage = "로그인 성공"
                    response.body()?.let { body ->
                        tokenManager.saveTokens(body.access_token, body.refresh_token)
                    }
                    onSuccess()
                } else {
                    loginMessage = "로그인 실패: ${response.code()}"
                    onFailure("아이디 또는 비밀번호를 다시 확인해주세요.")
                }
            } catch (e: Exception) {
                onFailure("오류 발생: ${e.localizedMessage}")
            }
        }
    }
}


class LoginViewModelFactory(
    private val tokenManager: TokenManager,
    private val apiService: MelogApi
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(tokenManager, apiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
