package com.noble.news.ui.components.video

import android.view.LayoutInflater
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.noble.news.R
import com.tencent.rtmp.TXVodPlayer
import com.tencent.rtmp.ui.TXCloudVideoView

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/8 20:20
 */
@Composable
fun VideoView(vodPlayer: TXVodPlayer) {

    AndroidView(factory = { context ->
        (LayoutInflater.from(context).inflate(R.layout.video, null, false)
            .findViewById(R.id.videoView) as TXCloudVideoView).apply {
            vodPlayer.setPlayerView(this)
        }
    })

}