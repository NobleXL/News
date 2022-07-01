package com.noble.news.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.noble.news.ui.components.TopAppBar

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/6/30 18:52
 */

@Composable
fun MineScreen() {
    Column(modifier = Modifier) {
        TopAppBar() {
            Text(text = "我的页面")
        }
        Text(text = "我的页面")
    }
}

@Preview
@Composable
fun MineScreenPreview() {
    MineScreen()
}

