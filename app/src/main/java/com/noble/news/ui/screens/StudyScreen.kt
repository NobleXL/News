package com.noble.news.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.noble.news.ui.components.TopAppBar

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/6/30 18:51
 */

@Composable
fun StudyScreen() {
    Column(modifier = Modifier.clickable {

    }) {
        TopAppBar() {
            Text(text = "学习页")
        }
        Text(text = "学习页")
    }
}

@Preview
@Composable
fun StudyScreenPreview() {
    StudyScreen()
}

