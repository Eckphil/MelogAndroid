package com.example.practice.ui.screens.signin

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.component.AppBar
import com.example.practice.ui.component.LineInput
import com.example.practice.ui.component.NoButtonAppBar
import com.example.practice.ui.component.RecButton
import com.example.practice.ui.component.onAction1ClickExample
import com.example.practice.ui.component.onBackClickExample
import com.example.practice.ui.component.onClickExample
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography

@Preview
@Composable
fun Signin(){
    Scaffold(
        topBar = { NoButtonAppBar("로그인", { onBackClickExample()}) },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding((innerPadding)),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Spacer(modifier = Modifier.height(160.dp))
                LineInput("이메일")
                Spacer(modifier = Modifier.height(40.dp))
                LineInput("비밀번호")
                Spacer(modifier = Modifier.height(30.dp))
                RecButton("로그인") { onClickExample() }
                Spacer(modifier = Modifier.height(30.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ){
                    TextButton(onClick = {onClickExample()}) {
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
                    TextButton(onClick = {onClickExample()}) {
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