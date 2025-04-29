package com.example.practice.ui.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.R
import com.example.practice.ui.component.AppBar
import com.example.practice.ui.component.BottomButton
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
fun Usergenre(){
    Scaffold(
        topBar = { NoButtonAppBar("장르 선택", { onBackClickExample()}) },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding((innerPadding)),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(modifier = Modifier.fillMaxWidth()){
                    Spacer(modifier = Modifier.width(20.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "어떤 장르의 음악을\n좋아하시나요?",
                            style = Typography.titleMedium,
                            fontSize = 36.sp,
                            lineHeight = 40.sp,
                            color = Lavender02
                        )
                        Text(
                            text = "멜로그에게 알려준다면 도움이 될거에요!",
                            style = Typography.titleMedium,
                            fontSize = 20.sp,
                            color = Lavender02
                        )
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.excitement),
                            contentDescription = "genre",
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                        )
                        Text(
                            text = "발라드",
                            style = Typography.titleMedium,
                            color = Lavender02
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.excitement),
                            contentDescription = "genre",
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                        )
                        Text(
                            text = "랩/힙합",
                            style = Typography.titleMedium,
                            color = Lavender02
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.excitement),
                            contentDescription = "genre",
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                        )
                        Text(
                            text = "댄스",
                            style = Typography.titleMedium,
                            color = Lavender02
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.excitement),
                            contentDescription = "genre",
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                        )
                        Text(
                            text = "인디",
                            style = Typography.titleMedium,
                            color = Lavender02
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.excitement),
                            contentDescription = "genre",
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                        )
                        Text(
                            text = "R&B",
                            style = Typography.titleMedium,
                            color = Lavender02
                        )
                    }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.excitement),
                            contentDescription = "genre",
                            modifier = Modifier
                                .width(120.dp)
                                .height(120.dp)
                        )
                        Text(
                            text = "록/메탈",
                            style = Typography.titleMedium,
                            color = Lavender02
                        )
                    }
                }
                Spacer(modifier = Modifier.height(30.dp))
                TextButton(onClick = {onClickExample()}) {
                    Text(
                        text = "저는 그다지 선호하는 장르가 없어요.",
                        style = Typography.bodyMedium,
                        fontWeight = FontWeight(600),
                        fontSize = 16.sp,
                        color = Lavender04,
                        textDecoration = TextDecoration.Underline,
                    )
                }
            }
        },
        bottomBar = { BottomButton("선택완료", { onClickExample()}) }
    )
}