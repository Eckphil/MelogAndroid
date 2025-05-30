package com.example.practice.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practice.ui.theme.Grey
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

@Composable
fun RecButton(text: String, onClick: () -> Unit){
    Button(
        onClick = onClick,
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
            text = text,
            style = Typography.titleLarge,
        )
    }
}

@Composable
fun RoundButton(text: String, onClick: () -> Unit){
    Button(
        onClick = onClick,
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
            text = text,
            style = Typography.titleLarge,
        )
    }
}

@Composable
fun BottomButton(text: String, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Lavender04,
            contentColor = White,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(124.dp)
            .navigationBarsPadding()
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                style = Typography.titleLarge,
            )
        }
    }
}

@Composable
fun Logout(text: String, onClick: () -> Unit){
    OutlinedButton(
        onClick = onClick,
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
            text = text,
            style = Typography.titleLarge,
        )
    }
}

@Composable
fun DeleteID(text: String, onClick: () -> Unit){
    Button(
        onClick = onClick,
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
            text = text,
            style = Typography.titleLarge,
        )
    }
}

@Composable
fun SRButton(text: String, onClick: () -> Unit){
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(size = 15.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Lavender04,
            contentColor = White,
            disabledContainerColor = Grey,
            disabledContentColor = White
        ),
        modifier = Modifier
            .width(140.dp)
            .height(40.dp)
    )
    {
        Text(
            text = text,
            style = Typography.titleMedium,
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun RecButtonPreview(){
    RecButton("text", {onClickExample()})
}

@Preview
@Composable
fun RoundButtonPreview(){
    RoundButton("text", {onClickExample()})
}

@Preview
@Composable
fun BottomButtonPreview(){
    BottomButton("text", {onClickExample()})
}

@Preview
@Composable
fun LogoutPreview(){
    Logout("text", {onClickExample()})
}

@Preview
@Composable
fun DeleteIDPreview(){
    DeleteID("text", {onClickExample()})
}

@Preview
@Composable
fun SRButtonPreview(){
    SRButton("text", {onClickExample()})
}

fun onClickExample() {

}