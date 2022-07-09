package com.noble.news.ui.components.video

import android.content.Context
import android.os.Bundle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.tencent.rtmp.ITXVodPlayListener
import com.tencent.rtmp.TXLiveConstants
import com.tencent.rtmp.TXVodPlayer

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/9 12:05
 */
class VodController(context: Context) {

    val playerValue = PlayerValue()

    val vodPlayer = TXVodPlayer(context).apply {
        setVodListener(object : ITXVodPlayListener {
            override fun onPlayEvent(player: TXVodPlayer?, event: Int, param: Bundle?) {
                when (event) {
                    //获取视频时长和进度
                    TXLiveConstants.PLAY_EVT_PLAY_PROGRESS -> {
                        playerValue.duration =
                            param?.getInt(TXLiveConstants.EVT_PLAY_DURATION)?.toLong() ?: 0L
                        playerValue.currentPosition =
                            param?.getInt(TXLiveConstants.EVT_PLAY_PROGRESS)?.toLong() ?: 0L
                    }
                }
            }

            override fun onNetStatus(player: TXVodPlayer?, param: Bundle?) {
                TODO("Not yet implemented")
            }

        })
    }

    /**
     * 开始播放
     *
     * @param url String
     */
    fun startPlay(url: String) {
        vodPlayer.startPlay(url)
    }

    /**
     * 停止播放
     */
    fun stopPlay() {
        vodPlayer.stopPlay(true)
    }

    /**
     * 暂停播放
     */
    fun pause() {
        vodPlayer.pause()
    }

    /**
     * 恢复播放
     */
    fun resume() {
        vodPlayer.resume()
    }

    /**
     * 设置播放进度
     *
     * @param millSeconds Long
     */
    fun seekTo(millSeconds: Long) {
        vodPlayer.seek((millSeconds / 1000).toInt())
    }
}

@Composable
fun rememberVodController(context: Context = LocalContext.current) = remember {
    VodController(context)
}