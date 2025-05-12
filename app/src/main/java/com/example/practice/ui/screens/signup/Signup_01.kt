package com.example.practice.ui.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.practice.R
import com.example.practice.ui.component.BottomButton
import com.example.practice.ui.component.LineInputWithAction
import com.example.practice.ui.component.NoButtonAppBar
import com.example.practice.ui.component.SRButton
import com.example.practice.ui.component.TitledLineInput
import com.example.practice.ui.component.TitledLineInputWithAction
import com.example.practice.ui.theme.Red
import com.example.practice.ui.theme.Typography
import com.example.practice.viewmodel.SignupViewModel

@Composable
fun Signup_01(navController: NavHostController, viewModel: SignupViewModel = viewModel()) {
    Scaffold(
        topBar = { NoButtonAppBar("회원 가입", { navController.popBackStack() }) },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TitledLineInputWithAction(
                    title = "이메일",
                    value = viewModel.userId,
                    placeholder = "example@email.com",
                    onValueChange = { viewModel.userId = it },
                    action = { SRButton("중복 확인", {}) }
                )
                Spacer(modifier = Modifier.height(10.dp))
                TitledLineInputWithAction(
                    title = "비밀번호",
                    value = viewModel.password,
                    placeholder = "영문, 숫자, 특수문자 포합 8글자 이상이어야 합니다.",
                    onValueChange = { viewModel.password = it },
                    action = {
                        IconButton(onClick = {}) {
                            val imageVector = ImageVector.vectorResource(id = R.drawable.eye)
                            Image(
                                imageVector = imageVector,
                                contentDescription = "eye",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                LineInputWithAction(
                    value = viewModel.passwordCheck,
                    placeholder = "비밀번호 확인",
                    onValueChange = { viewModel.passwordCheck = it },
                    action = {
                        IconButton(onClick = {}) {
                            val imageVector = ImageVector.vectorResource(id = R.drawable.eye)
                            Image(
                                imageVector = imageVector,
                                contentDescription = "eye",
                                modifier = Modifier.size(24.dp)
                            )
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
                Column {
                    TitledLineInput("휴대폰번호", viewModel.phone, "010-0000-0000", { viewModel.phone = it })
                    Text("휴대폰번호를 입력해주세요.", style = Typography.titleSmall, color = Red)
                }
                Spacer(modifier = Modifier.height(10.dp))
                Column {
                    TitledLineInput("닉네임", viewModel.nickname, "멜로그유저", { viewModel.nickname = it })
                    Text("닉네임을 입력해주세요.", style = Typography.titleSmall, color = Red)
                }
            }
        },
        bottomBar = {
            BottomButton("가입완료") {
                viewModel.onSignup(
                    onSuccess = {
                        navController.navigate("Usergenre")
                    },
                    onFailure = { error ->
                        // 예: Snackbar, Toast 등 UI에 알림 표시
                        println("회원가입 실패: $error")
                    }
                )
            }
        }
    )
}
