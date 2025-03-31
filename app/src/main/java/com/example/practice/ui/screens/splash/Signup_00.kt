package com.example.practice.ui.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.component.RoundButton
import com.example.practice.ui.component.onClickExample
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

@Preview
@Composable
fun Signup_00(){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.Bottom
            ) {
                Spacer(modifier = Modifier.width(30.dp))
                Text(
                    text = "일기와\n음악이\n만나는곳",
                    style = Typography.displayLarge,
                    fontSize = 44.sp,
                    lineHeight = 60.sp,
                    color = Lavender04
                )
                Spacer(modifier = Modifier.width(20.dp))
                Image(
                    painter = painterResource(id = R.drawable.character),
                    contentDescription = "Melog Character 01",
                    modifier = Modifier
                        .width(180.dp)
                        .height(145.dp),
                )
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.width(30.dp))
                    val imageVector = ImageVector.vectorResource(id = R.drawable.check)
                    Image(
                        imageVector = imageVector,
                        contentDescription = "check"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "일기를 통한 사용자 감정 분석",
                        style = Typography.displaySmall,
                        color = Lavender02
                    )
                }
                Spacer(modifier = Modifier.height(40.dp))
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.width(30.dp))
                    val imageVector = ImageVector.vectorResource(id = R.drawable.check)
                    Image(
                        imageVector = imageVector,
                        contentDescription = "check"
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = "감정에 맞는 노래 추천",
                        style = Typography.displaySmall,
                        color = Lavender02
                    )
                }
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                RoundButton("회원가입") { onClickExample() }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "이미 회원 가입을 하셨나요?",
                    style = Typography.bodyMedium,
                    fontWeight = FontWeight(600),
                    fontSize = 16.sp,
                    color = Lavender02
                )
                TextButton(onClick = {onClickExample()}) {
                    Text(
                        text = "로그인",
                        style = Typography.bodyMedium,
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = Lavender04,
                        textDecoration = TextDecoration.Underline
                    )
                }
            }
        }
    }
}
