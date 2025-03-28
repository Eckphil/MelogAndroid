package com.example.practice.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

@Preview
@Composable
fun RecButton(){
    Button(
        onClick = {},
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Lavender04,
            contentColor = White,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .width(378.dp)
            .height(80.dp)
    )
    {
        Text(
            text = "Text",
            style = Typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun RoundButton(){
    Button(
        onClick = {},
        shape = RoundedCornerShape(size = 60.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Lavender04,
            contentColor = White,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .width(280.dp)
            .height(80.dp)
    )
    {
        Text(
            text = "Text",
            style = Typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun BottomButton(){
    Button(
        onClick = {},
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Lavender04,
            contentColor = White,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .width(412.dp)
            .height(124.dp)
    )
    {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
            Text(
                text = "Text",
                style = Typography.titleLarge,
            )
        }
    }
}

@Preview
@Composable
fun Logout(){
    OutlinedButton(
        onClick = {},
        shape = RoundedCornerShape(size = 15.dp),
        border = BorderStroke(
            width = 1.dp,
            color = Lavender04
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = Lavender04,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .width(142.dp)
            .height(48.dp)
    )
    {
        Text(
            text = "Text",
            style = Typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun DeleteID(){
    Button(
        onClick = {},
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Lavender04,
            contentColor = White,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .width(142.dp)
            .height(48.dp)
    )
    {
        Text(
            text = "Text",
            style = Typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun SRButton(){
    Button(
        onClick = {},
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Lavender04,
            contentColor = White,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .width(100.dp)
            .height(40.dp)
    )
    {
        Text(
            text = "Text",
            style = Typography.titleMedium,
        )
    }
}