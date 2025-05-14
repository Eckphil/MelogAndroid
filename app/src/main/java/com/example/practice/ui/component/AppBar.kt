package com.example.practice.ui.component

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practice.R
import com.example.practice.ui.theme.Lavender01
import com.example.practice.ui.theme.Lavender02
import com.example.practice.ui.theme.Lavender03
import com.example.practice.ui.theme.Lavender04
import com.example.practice.ui.theme.Typography
import com.example.practice.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(title: String, text: String, onBackClick: () -> Unit, onActionClick: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = White,
            titleContentColor = Lavender02,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        title = {
            Text(
                text = title,
                style = Typography.titleMedium,
                modifier = Modifier
                    .fillMaxHeight() // ✅ 높이 최대 확장
                    .wrapContentHeight(Alignment.CenterVertically)
            )

        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                val imageVector = ImageVector.vectorResource(id = R.drawable.previous)
                Image(
                    imageVector = imageVector,
                    contentDescription = "check"
                )
            }
        },
        actions = {
            TextButton(onClick = onActionClick) {
                Text(
                    text = text,
                    style = Typography.titleMedium
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TwoButtonAppBar(title: String, text1: String, text2: String,
                    onBackClick: () -> Unit, onAction1Click: () -> Unit, onAction2Click: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = White,
            titleContentColor = Lavender02,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        title = {
            Text(
                text = title,
                style = Typography.titleMedium,
                modifier = Modifier
                    .fillMaxHeight() // ✅ 높이 최대 확장
                    .wrapContentHeight(Alignment.CenterVertically)
            )

        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                val imageVector = ImageVector.vectorResource(id = R.drawable.previous)
                Image(
                    imageVector = imageVector,
                    contentDescription = "check"
                )
            }
        },
        actions = {
            TextButton(onClick = onAction1Click) {
                Text(
                    text = text1,
                    style = Typography.titleMedium,
                    color = Lavender04
                )
            }
            TextButton(onClick = onAction2Click) {
                Text(
                    text = text2,
                    style = Typography.titleMedium,
                    color = Lavender02
                )
            }
        },
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoButtonAppBar(title: String, onBackClick: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = White,
            titleContentColor = Lavender02,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding(),
        title = {
            Text(
                text = title,
                style = Typography.titleMedium,
                modifier = Modifier
                    .fillMaxHeight() // ✅ 높이 최대 확장
                    .wrapContentHeight(Alignment.CenterVertically)
            )

        },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                val imageVector = ImageVector.vectorResource(id = R.drawable.previous)
                Image(
                    imageVector = imageVector,
                    contentDescription = "check"
                )
            }
        },
                actions = {
            // 비워두기: Action 버튼 없음
            Spacer(modifier = Modifier.width(48.dp)) // 타이틀이 가운데 정렬되도록 균형 맞춤
        },
        scrollBehavior = scrollBehavior,
    )
}

@Preview
@Composable
fun BottomAppBar() {
    val onCalendarClick = { /* 캘린더 이동 */ }
    val onStatisticClick = { /* 통계 이동 */ }
    val onCommunityClick = { /* 커뮤니티 이동 */ }
    val onHistoryClick = { /* 히스토리 이동 */ }
    val onUserClick = { /* 유저 정보 이동 */ }

    val bottomPadding = WindowInsets.navigationBars.asPaddingValues().calculateBottomPadding()

    // 아이템 이름, 아이콘, 설명, 클릭 함수 등록
    val menuItems = listOf(
        Triple("캘린더", R.drawable.calendar, "calendar") to onCalendarClick,
        Triple("통계", R.drawable.statistic, "statistic") to onStatisticClick,
        Triple("커뮤니티", R.drawable.community, "community") to onCommunityClick,
        Triple("히스토리", R.drawable.history, "history") to onHistoryClick,
        Triple("유저 정보", R.drawable.user, "user") to onUserClick
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(White)
            .padding(top = 10.dp,bottom = bottomPadding),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        menuItems.forEach { (item, onClick) ->
            val (label, iconId, contentDesc) = item
            Column(
                modifier = Modifier
                    .width(76.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = onClick) {
                    val imageVector = ImageVector.vectorResource(id = iconId)
                    Image(
                        imageVector = imageVector,
                        contentDescription = contentDesc,
                        modifier = Modifier
                            .size(36.dp) // ✅ 아이콘 크기 설정
                    )
                }
                Text(
                    text = label,
                    style = Typography.titleSmall,
                    color = Lavender03
                )
            }
        }
    }
}

@Composable
fun ScrollContent(innerPadding: PaddingValues) {
    val range = 1..100

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = innerPadding,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(range.count()) { index ->
            Text(text = "- List item number ${index + 1}")
        }
    }
}

@Preview
@Composable
fun AppBarPreview(){
    AppBar("Title", "Text", {onBackClickExample()}, { onAction1ClickExample()})
}

@Preview
@Composable
fun TwoButtonAppBarPreview(){
    TwoButtonAppBar("Title", "Text1", "Text2", {onBackClickExample()}, { onAction1ClickExample()}, {onAction2ClickExample()})
}

@Preview
@Composable
fun NoButtonAppBarPreview(){
    NoButtonAppBar("Title", {onBackClickExample()})
}

fun onBackClickExample(){

}

fun onAction1ClickExample(){

}

fun onAction2ClickExample(){

}