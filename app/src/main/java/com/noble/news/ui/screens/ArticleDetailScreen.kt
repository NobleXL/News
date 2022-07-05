package com.noble.news.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.statusBarsPadding
import com.noble.news.ui.components.WebView
import com.noble.news.ui.components.rememberWebViewState
import com.noble.news.viewmodel.ArticleViewModel

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/5 10:33
 */

@Composable
fun ArticleDetailScreen(articleViewModel: ArticleViewModel = viewModel(), onBack: () -> Unit) {

    val webViewState = rememberWebViewState(data = articleViewModel.content)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "文章详情",
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        fontSize = 18.sp
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.NavigateBefore,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                onBack()
                            }
                            .padding(8.dp)
                    )
                },
                actions = {
                    Icon(
                        imageVector = Icons.Default.TextFields,
                        contentDescription = null,
                        modifier = Modifier
                            .clickable {
                                //TODO 点击设置文字大小
                            }
                            .padding(8.dp))
                }
            )
        },
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .statusBarsPadding()
    ) {
        WebView(webViewState)
    }
}

