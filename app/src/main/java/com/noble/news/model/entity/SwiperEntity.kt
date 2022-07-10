package com.noble.news.model.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/1 15:39
 */
@JsonClass(generateAdapter = true)
data class SwiperEntity(
    @Json(name = "imgUrl") val imageUrl: String,
    val title: String? = null
)

data class SwiperResponse(val data: List<SwiperEntity>?) : BaseResponse()