package com.noble.news.model.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/1 19:16
 */
@JsonClass(generateAdapter = true)
data class ArticleEntity(
    val title: String,
    val source: String,
    @Json(name = "time")
    val timestamp: String
)

data class ArticleListResponse(val data: List<ArticleEntity>?): BaseResponse()