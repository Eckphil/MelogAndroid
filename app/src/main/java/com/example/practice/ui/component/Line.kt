package com.example.practice.ui.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.Black
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Typography

@Composable
fun LineInput(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.width(380.dp)) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = Typography.titleMedium.copy(color = Black),
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = Typography.titleMedium.copy(color = Grey)
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Grey)
    }
}

@Composable
fun TitledLineInput(
    title: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.width(380.dp)) {
        Text(
            text = title,
            modifier = Modifier.padding(bottom = 30.dp),
            style = Typography.titleMedium,
            color = Lavender02
        )
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = Typography.titleMedium.copy(color = Black),
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = Typography.titleMedium.copy(color = Grey)
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Grey)
    }
}

@Composable
fun LineInputWithAction(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    action: @Composable () -> Unit
) {
    Column(modifier = Modifier.width(380.dp)) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                textStyle = Typography.titleMedium.copy(color = Black),
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField ->
                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = Typography.titleMedium.copy(color = Grey)
                            )
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            action()
        }
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Grey)
    }
}

@Composable
fun TitledLineInputWithAction(
    title: String,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit,
    action: @Composable () -> Unit
) {
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
                value = value,
                onValueChange = onValueChange,
                textStyle = Typography.titleMedium.copy(color = Black),
                modifier = Modifier.weight(1f),
                decorationBox = { innerTextField ->
                    Box {
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                style = Typography.titleMedium.copy(color = Grey)
                            )
                        }
                        innerTextField()
                    }
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            action()
        }
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Grey)
    }
}

@Composable
fun PopupLineInput(
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {
    Column(modifier = Modifier.width(280.dp)) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = Typography.titleMedium.copy(color = Black),
            modifier = Modifier.fillMaxWidth(),
            decorationBox = { innerTextField ->
                Box {
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            style = Typography.titleMedium.copy(color = Grey)
                        )
                    }
                    innerTextField()
                }
            }
        )
        Spacer(modifier = Modifier.height(30.dp))
        HorizontalDivider(thickness = 1.dp, color = Grey)
    }
}



@Preview
@Composable
fun LineInputPreview() {
    var value by remember { mutableStateOf("아이디") }
    LineInput(
        value = value,
        placeholder = "아이디",
        onValueChange = { value = it }
    )
}

@Preview
@Composable
fun TitledLineInputPreview() {
    var value by remember { mutableStateOf("이메일") }
    TitledLineInput(
        title = "이메일 주소",
        value = value,
        placeholder = "이메일",
        onValueChange = { value = it }
    )
}

@Preview
@Composable
fun LineInputWithActionPreview() {
    var value by remember { mutableStateOf("이메일 입력") }
    LineInputWithAction(
        value = value,
        placeholder = "이메일 입력",
        onValueChange = { value = it },
        action = {
            SRButton("중복 확인") { onClickExample() }
        }
    )
}

@Preview
@Composable
fun TitledLineInputWithActionPreview() {
    var value by remember { mutableStateOf("이메일 입력") }
    TitledLineInputWithAction(
        title = "로그인 시 사용할 이메일",
        value = value,
        placeholder = "이메일 입력",
        onValueChange = { value = it },
        action = {
            SRButton("중복 확인") { onClickExample() }
        }
    )
}

@Preview
@Composable
fun PopupLineInputPreview() {
    var value by remember { mutableStateOf("닉네임 입력") }
    PopupLineInput(
        value = value,
        placeholder = "닉네임 입력",
        onValueChange = { value = it }
    )
}
