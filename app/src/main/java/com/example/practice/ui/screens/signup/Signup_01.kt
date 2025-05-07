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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
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

@Composable
fun Signup_01(navController: NavHostController){
    Scaffold(
        topBar = { NoButtonAppBar("회원 가입", {navController.popBackStack()}) },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding((innerPadding)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TitledLineInputWithAction(
                        title = "로그인 시 사용할 이메일",
                        input = "이메일 입력",
                        action = {SRButton("중복 확인", {})}
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    TitledLineInputWithAction(
                        title = "로그인 시 사용할 비밀번호",
                        input = "비밀번호 입력",
                        action = {
                            IconButton(onClick={}) {
                                val imageVector = ImageVector.vectorResource(id = R.drawable.eye)
                                Image(
                                    imageVector = imageVector,
                                    contentDescription = "eye",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    LineInputWithAction(
                        input = "비밀번호 재입력",
                        action = {
                            IconButton(onClick={}) {
                                val imageVector = ImageVector.vectorResource(id = R.drawable.eye)
                                Image(
                                    imageVector = imageVector,
                                    contentDescription = "eye",
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column{
                        TitledLineInput("휴대폰번호", "휴대폰번호 입력")
                        Text(
                            text = "휴대폰번호를 입력해주세요.",
                            style = Typography.titleSmall,
                            color = Red
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.Center
                ) {
                    Column{
                        TitledLineInput("닉네임", "닉네임 입력")
                        Text(
                            text = "닉네임을 입력해주세요.",
                            style = Typography.titleSmall,
                            color = Red
                        )
                    }
                }
            }
        },
        bottomBar = {
            BottomButton("가입완료", { navController.navigate("Usergenre") })
        }
    )
}
