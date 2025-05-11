package com.example.practice.screens

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.practice.api.ApiClient
import com.example.practice.api.UserLoginRequest
import com.example.practice.ui.theme.Grey
import kotlinx.coroutines.*

@Composable
fun LoginTestScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var loginResult by remember { mutableStateOf<String?>(null) }
    val coroutineScope = rememberCoroutineScope()

    // 예외 처리용 CoroutineExceptionHandler
    val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        // 예외 발생 시 로그인 결과를 오류 메시지로 업데이트
        loginResult = "에러 발생: ${exception.message}"
    }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("이메일") }
        )

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("비밀번호") },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // 로그인 버튼 클릭 시 코루틴을 사용하여 로그인 처리
            coroutineScope.launch(exceptionHandler) {
                // 로그인 진행 상태 표시
                loginResult = "로그인 중..."
                try {
                    // 로그인 요청을 suspend 함수로 호출
                    val response = ApiClient.api.loginUser(UserLoginRequest(email, password))

                    // 로그인 성공 시 처리
                    if (response.isSuccessful) {
                        val token = response.body()?.access_token // accessToken을 가져옵니다.
                        loginResult = "성공! 토큰: $token"
                    } else {
                        // 로그인 실패 시
                        loginResult = "실패: ${response.code()} - ${response.message()}"
                    }
                } catch (e: Exception) {
                    // 예외가 발생했을 때 처리
                    loginResult = "에러 발생: ${e.localizedMessage}"
                }
            }
        }) {
            Text("로그인 테스트")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 로그인 결과 출력
        loginResult?.let {
            Text(text = it, color = Grey)
        }
    }
}
