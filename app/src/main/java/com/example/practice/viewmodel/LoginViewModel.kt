//package com.example.practice.viewmodel
//
//import com.example.practice.api.ApiClient
//import com.example.practice.api.UserLoginRequest
//import com.example.practice.api.UserLoginResponse
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//fun login(userId: String, password: String, onResult: (Boolean, String) -> Unit) {
//    val loginRequest = UserLoginRequest(user_id = userId, password = password)
//
//    ApiClient.api.loginUser(loginRequest).enqueue(object : Callback<UserLoginResponse> {
//        override fun onResponse(
//            call: Call<UserLoginResponse>,
//            response: Response<UserLoginResponse>
//        ) {
//            if (response.isSuccessful) {
//                val token = response.body()?.access_token ?: ""
//                onResult(true, token) // 로그인 성공
//            } else {
//                onResult(false, "로그인 실패: ${response.code()}")
//            }
//        }
//
//        override fun onFailure(call: Call<UserLoginResponse>, t: Throwable) {
//            onResult(false, "네트워크 오류: ${t.message}")
//        }
//    })
//}