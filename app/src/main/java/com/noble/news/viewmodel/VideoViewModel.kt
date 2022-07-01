package com.noble.news.viewmodel

import androidx.lifecycle.ViewModel
import com.noble.news.model.entity.VideoEntity

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/1 20:41
 */
class VideoViewModel : ViewModel() {
    var list = listOf(
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
        ),
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner2.webp"
        ),
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner3.webp"
        ),
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner4.jpg"
        ),
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner5.jpg"
        ),
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
        ),
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
        ),
        VideoEntity(
            title = "行测老师告诉你如何定制合适自己的学习方案",
            type = "视频课程",
            duration = "00:02:00",
            imageUrl = "https://docs.bughub.icu/compose/assets/banner1.webp"
        )
    )
        private set
}