package com.noble.news.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.noble.news.ui.theme.Blue200
import com.noble.news.ui.theme.Blue700


/**
 * @author 小寒
 * @version 1.0
 * @date 2022/6/30 18:58
 */

/**
 * 统一标题栏
 *
 * @param modifier
 * @param content  标题栏内容
 */
@Composable
fun TopAppBar(statusBarHeight: Int, content: @Composable () -> Unit) {

    //标题栏高度
    val appBarHeight = 56.dp

    //转换状态栏高度 px 为 dp
    val statusBarHeightDp = with(LocalDensity.current) {
        statusBarHeight.toDp()
    }

    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(
                        Blue700,
                        Blue200
                    )
                )
            )
            .fillMaxWidth()
            .height(appBarHeight + statusBarHeightDp)
            .padding(top = statusBarHeightDp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }

}

@Preview
@Composable
fun TopAppBarPreview() {
    TopAppBar(30) {
        Text("标题")
    }
}

