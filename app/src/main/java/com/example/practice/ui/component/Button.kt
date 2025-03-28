package com.example.practice.ui.component

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.ui.theme.Typography

@Preview
@Composable
fun RecButton(){
    Button(
        onClick = {},
        shape = RectangleShape,
        modifier = Modifier
            .width(378.dp)
            .height(80.dp)
    )
    {
        Text(
            text = "Text",
            style = Typography.titleLarge
        )
    }
}

