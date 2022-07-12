package com.noble.news.model.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/1 20:40
 */
@JsonClass(generateAdapter = true)
data class VideoEntity(
    val title: String,
    val type: String,
    val duration: String,
    @Json(name = "cover")
    val imageUrl: String
)

data class VideoListResponse(val data: List<VideoEntity>?) : BaseResponse()