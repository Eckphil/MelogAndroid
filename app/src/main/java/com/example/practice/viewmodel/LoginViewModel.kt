package com.example.practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.example.practice.api.ApiClient
import com.example.practice.api.UserLoginRequest
import retrofit2.HttpException
import java.io.IOException

class LoginViewModel : ViewModel() {

    var email by mutableStateOf("")
        private set

    var password by mutableStateOf("")
        private set

    var loginMessage by mutableStateOf("")
        private set

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun login(
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {
        viewModelScope.launch {
            try {
                val response = ApiClient.api.loginUser(UserLoginRequest(email, password))
                if (response.isSuccessful) {
                    loginMessage = "로그인 성공"
                    onSuccess()
                } else {
                    loginMessage = "로그인 실패: ${response.code()}"
                    onFailure("아이디 또는 비밀번호를 다시 확인해주세요.")
                }
            } catch (e: IOException) {
                loginMessage = "네트워크 오류"
                onFailure("네트워크 오류가 발생했습니다.")
            } catch (e: HttpException) {
                loginMessage = "서버 오류"
                onFailure("서버 오류가 발생했습니다.")
            } catch (e: Exception) {
                loginMessage = "알 수 없는 오류"
                onFailure("알 수 없는 오류: ${e.localizedMessage}")
            }
        }
    }
}
