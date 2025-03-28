package com.example.practice.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

@Composable
fun Popup(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .width(380.dp)
                .height(200.dp),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = White,
                contentColor =  Lavender02,
                disabledContainerColor =  White,
                disabledContentColor = Lavender02
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Title",
                    style = Typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .wrapContentHeight(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Text",
                    style = Typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)  // 높이 비율 조절
                        .wrapContentHeight(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )
                Button(
                    onClick = {},
                    shape = RoundedCornerShape(size = 15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Lavender04,
                        contentColor = Lavender02,
                        disabledContainerColor = Grey,
                        disabledContentColor = White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                {
                    Text(
                        text = "OK",
                        style = Typography.titleMedium,
                    )
                }
            }
        }
    }
}

@Composable
fun YNPopup(onDismissRequest: () -> Unit) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .width(380.dp)
                .height(200.dp),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = White,
                contentColor =  Lavender02,
                disabledContainerColor =  White,
                disabledContentColor = Lavender02
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Title",
                    style = Typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .wrapContentHeight(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = "Text",
                    style = Typography.bodyMedium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)  // 높이 비율 조절
                        .wrapContentHeight(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )
                Row(
                    modifier = Modifier
                        .height(60.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly, // 버튼 간격 조정
                    verticalAlignment = Alignment.CenterVertically
                ){
                    TextButton(onClick = {}) {
                        Text(
                            text = "NO",
                            style = Typography.titleLarge,
                            fontSize = 32.sp,
                            color = Grey
                        )
                    }
                    TextButton(onClick = {}) {
                        Text(
                            text = "YES",
                            style = Typography.titleLarge,
                            fontSize = 32.sp,
                            color = Lavender04
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputPopup(onDismissRequest: () -> Unit) {
    var text by remember{ mutableStateOf("Input") }

    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            modifier = Modifier
                .width(380.dp)
                .height(200.dp),
            shape = RoundedCornerShape(15.dp),
            colors = CardDefaults.cardColors(
                containerColor = White,
                contentColor =  Lavender02,
                disabledContainerColor =  White,
                disabledContentColor = Lavender02
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Title",
                    style = Typography.titleLarge,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .wrapContentHeight(Alignment.CenterVertically),
                    textAlign = TextAlign.Center
                )

                TextField(
                    value = text,
                    onValueChange = { text = it },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        containerColor = White,
                        cursorColor = Lavender02,         // 커서 색상 검은색
                        focusedIndicatorColor = Lavender02, // 포커스 시 밑줄 검은색
                        unfocusedIndicatorColor = Grey, // 포커스 해제 시 밑줄 회색
                        disabledIndicatorColor = Grey, // 비활성화 시 밑줄 회색
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                Button(
                    onClick = {},
                    shape = RoundedCornerShape(size = 15.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Lavender04,
                        contentColor = Lavender02,
                        disabledContainerColor = Grey,
                        disabledContentColor = White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                )
                {
                    Text(
                        text = "OK",
                        style = Typography.titleMedium,
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun PopupPreview(){
    Popup({ onDismissRequest() })
}

@Preview
@Composable
fun YNPopupPreview(){
    YNPopup({ onDismissRequest() })
}

@Preview
@Composable
fun InputPopupPreview(){
    InputPopup({ onDismissRequest() })
}

fun onDismissRequest(){

}