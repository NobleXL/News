package com.noble.news.model.service

import com.noble.news.model.Network
import com.noble.news.model.entity.ArticleListResponse
import com.noble.news.model.entity.VideoListResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/12 14:07
 */
interface VideoService {
    @GET("video/list")
    suspend fun list(
        @Query("pageOffset") pageOffset: Int,
        @Query("pageSize") pageSize: Int
    ): VideoListResponse

    companion object {
        fun instance(): VideoService {
            return Network.createService(VideoService::class.java)
        }
    }
}