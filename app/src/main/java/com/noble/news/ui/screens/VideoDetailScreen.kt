package com.noble.news.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.NavigateBefore
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.statusBarsPadding
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.noble.news.module.webview.WebView
import com.noble.news.module.webview.rememberWebViewState
import com.noble.news.ui.components.video.VideoPlayer
import com.noble.news.ui.components.video.VideoView
import com.noble.news.ui.components.video.rememberVodController
import com.noble.news.ui.theme.Blue700
import com.noble.news.viewmodel.VideoViewModel
import com.tencent.rtmp.TXPlayerGlobalSetting
import com.tencent.rtmp.TXVodPlayConfig
import com.tencent.rtmp.TXVodPlayer

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/6 20:09
 */
@Composable
fun VideoDetailScreen(videoViewModel: VideoViewModel = viewModel(), onBack: () -> Unit) {

    val systemUiController = rememberSystemUiController()

    val webViewState = rememberWebViewState(data = videoViewModel.videoDesc)

    val vodController = rememberVodController(
        videoUrl = videoViewModel.videoUrl,
        coverUrl = videoViewModel.coverUrl
    )

    val configuration = LocalConfiguration.current

    var scaffoldModifier by remember {
        mutableStateOf(Modifier.alpha(1f))
    }

    var videoBoxModifier by remember {
        mutableStateOf(
            Modifier.aspectRatio(16 / 9f)
        )
    }

    //设置播放引擎的全局缓存目录和缓存大小(不然会出现闪退情况)
    TXPlayerGlobalSetting.setCacheFolderPath(LocalContext.current.getExternalFilesDir(null)?.absolutePath + "/cache")
    TXPlayerGlobalSetting.setMaxCacheSize(1)

    //TODO 横屏后，点击屏幕状态栏即显示出来，而且不会再隐藏，如何处理这个问题？
    LaunchedEffect(configuration.orientation) {
        vodController.restore()
        if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            videoBoxModifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16 / 9f)
            systemUiController.isSystemBarsVisible = true
            scaffoldModifier = Modifier
                .background(Blue700)
                .statusBarsPadding()
        } else {
            videoBoxModifier = Modifier
                .fillMaxSize()
            systemUiController.isSystemBarsVisible = false
            scaffoldModifier = Modifier
        }
    }

    Scaffold(
        topBar = {
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
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
            }
        },
        modifier = scaffoldModifier
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            //视频区域
            Box(modifier = videoBoxModifier) {
                VideoPlayer(vodController = vodController)
            }
            //想让标题一起滚动，有两个方案
            //方案一：把标题放到视频简介的 html 文本中去
            //方案二：计算 视频简介在 webview中的高度，然后动态设置 webview 的高度
            //简介？
            WebView(state = webViewState)
        }
    }
}


