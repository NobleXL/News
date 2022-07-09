package com.noble.news.ui.components.video

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/9 12:59
 *
 * 播放器相关数据类
 *
 */
class PlayerValue {

    //视频总时长
    var duration by mutableStateOf(0L)

    //当前播放进度
    var currentPosition by mutableStateOf(0L)

}