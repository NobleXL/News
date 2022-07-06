package com.noble.news.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.statusBarsPadding
import com.noble.news.module.webview.WebView
import com.noble.news.module.webview.rememberWebViewState
import com.noble.news.viewmodel.VideoViewModel

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/6 20:09
 */
@Composable
fun VideoDetailScreen(videoViewModel: VideoViewModel = viewModel(), onBack: () -> Unit) {

    val webViewState = rememberWebViewState(data = videoViewModel.videoDesc)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "视频详情",
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
                })
        },
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .statusBarsPadding()
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            //视频区域
            Box(modifier = Modifier.height(200.dp))
            //想让标题一起滚动，有两个方案
            //方案一：把标题放到视频简介的 html 文本中去
            //方案二：计算 视频简介在 webview中的高度，然后动态设置 webview 的高度
            //简介？
            WebView(state = webViewState)
        }
    }
}


