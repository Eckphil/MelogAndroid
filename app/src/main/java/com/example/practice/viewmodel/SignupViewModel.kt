package com.example.practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.*
import com.example.practice.api.ApiClient
import com.example.practice.api.UserCreateRequest
import retrofit2.HttpException
import java.io.IOException

class SignupViewModel : ViewModel() {
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
        // 비밀번호 확인 검증
        if (password != passwordCheck) {
            onFailure("비밀번호가 일치하지 않습니다.")
            return
        }

        viewModelScope.launch {
            try {
                val request = UserCreateRequest(
                    user_id = userId,
                    password = password,
                    nickname = nickname,
                    phone = if (phone.isBlank()) null else phone
                )

                val response = ApiClient.api.registerUser(request)

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
