package com.example.practice.ui.component

import android.graphics.Paint.Style
import android.icu.text.CaseMap.Title
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Typography

@Composable
fun LineInput(input: String){
    var text by remember{ mutableStateOf(input) }

    Column(
        modifier = Modifier.width(380.dp)) {
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            textStyle = Typography.titleMedium.copy(
                color = if (text == input) Grey else Black
            ),
            modifier = Modifier
                .fillMaxWidth(),

        )
        Spacer(modifier = Modifier.height(30.dp)) // 30dp 간격 추가
        HorizontalDivider(thickness = 1.dp, color = Grey) // 구분선 추가
    }
}

@Composable
fun TitledLineInput(title: String, input: String){
    var text by remember{ mutableStateOf(input) }

    Column(
        modifier = Modifier.width(380.dp)) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 30.dp),
            style = Typography.titleMedium,
            color = Lavender02
        )
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            textStyle = Typography.titleMedium.copy(
                color = if (text == input) Grey else Black
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp)) // 30dp 간격 추가
        HorizontalDivider(thickness = 1.dp, color = Grey) // 구분선 추가
    }
}

@Composable
fun LineInputWithAction(
    input: String,
    action: @Composable () -> Unit
) {
    var text by remember { mutableStateOf(input) }

    Column(modifier = Modifier.width(380.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = Typography.titleMedium.copy(
                    color = if (text == input) Grey else Black
                ),
                modifier = Modifier
                    .weight(1f) // Row 내에서 가변 너비 설정
            )
            Spacer(modifier = Modifier.width(8.dp)) // 텍스트 필드와 action 사이 여백
            action() // 여기에 버튼이나 아이콘 등 전달
        }
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Grey)
    }
}

@Composable
fun TitledLineInputWithAction(
    title: String,
    input: String,
    action: @Composable () -> Unit
) {
    var text by remember { mutableStateOf(input) }

    Column(modifier = Modifier.width(380.dp)) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 30.dp),
            style = Typography.titleMedium,
            color = Lavender02
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(
                value = text,
                onValueChange = { text = it },
                textStyle = Typography.titleMedium.copy(
                    color = if (text == input) Grey else Black
                ),
                modifier = Modifier
                    .weight(1f) // Row 내에서 가변 너비 설정
            )
            Spacer(modifier = Modifier.width(8.dp)) // 텍스트 필드와 action 사이 여백
            action() // 여기에 버튼이나 아이콘 등 전달
        }
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Grey)
    }
}

@Composable
fun PopupLineInput(input: String){
    var text by remember{ mutableStateOf(input) }

    Column(
        modifier = Modifier.width(280.dp)) {
        BasicTextField(
            value = text,
            onValueChange = { text = it },
            textStyle = Typography.titleMedium.copy(
                color = if (text == input) Grey else Black
            ),
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp)) // 30dp 간격 추가
        HorizontalDivider(thickness = 1.dp, color = Grey) // 구분선 추가
    }
}

@Preview
@Composable
fun LineInputPreview(){
    LineInput("input")
}

@Preview
@Composable
fun TitledLineInputPreview(){
    TitledLineInput("title", "input")
}

@Preview
@Composable
fun LineInputWithActionPreview(){
    LineInputWithAction(
        input = "이메일 입력",
        action = {
            SRButton("중복 확인") { onClickExample() }
        }
    )
}

@Preview
@Composable
fun TitledLineInputWithActionPreview(){
    TitledLineInputWithAction(
        title = "로그인 시 사용할 이메일",
        input = "이메일 입력",
        action = {
            SRButton("중복 확인") { onClickExample() }
        }
    )
}

@Preview
@Composable
fun PopupLineInputPreview(){
    PopupLineInput("Input")
}