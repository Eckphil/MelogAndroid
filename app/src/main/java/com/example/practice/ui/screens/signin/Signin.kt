package com.example.practice.ui.screens.signin

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.practice.ui.component.*
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Typography
import com.example.practice.viewmodel.LoginViewModel

@Composable
fun Signin(navController: NavHostController, loginViewModel: LoginViewModel = viewModel()) {
    val context = LocalContext.current

    Scaffold(
        topBar = { NoButtonAppBar("로그인", { onBackClickExample() }) },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(160.dp))

                // Email Input
                LineInput(
                    value = loginViewModel.email,
                    placeholder = "아이디",
                    onValueChange = { loginViewModel.onEmailChanged(it) }
                )

                Spacer(modifier = Modifier.height(40.dp))

                // Password Input
                LineInput(
                    value = loginViewModel.password,
                    placeholder = "비밀번호",
                    onValueChange = { loginViewModel.onPasswordChanged(it) }
                )

                Spacer(modifier = Modifier.height(30.dp))

                // Login Button
                RecButton("로그인") {
                    loginViewModel.login(
                        onSuccess = {
                            navController.navigate("Calender")
                        },
                        onFailure = { errorMessage ->
                            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    )
                }

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(onClick = { onClickExample() }) {
                        Text(
                            text = "아이디 찾기",
                            style = Typography.titleMedium,
                            fontSize = 16.sp,
                            color = Lavender02
                        )
                    }

                    VerticalDivider(
                        color = Lavender02,
                        thickness = 1.dp,
                        modifier = Modifier.height(20.dp)
                    )

                    TextButton(onClick = { onClickExample() }) {
                        Text(
                            text = "비밀번호 찾기",
                            style = Typography.titleMedium,
                            fontSize = 16.sp,
                            color = Lavender02
                        )
                    }
                }
            }
        }
    )
}
