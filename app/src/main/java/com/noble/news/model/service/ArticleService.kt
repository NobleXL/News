package com.noble.news.model.service

import com.noble.news.model.Network
import com.noble.news.model.entity.ArticleListResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/11 9:48
 */
interface ArticleService {

    @GET("article/list")
    suspend fun list(
        @Query("pageOffset") pageOffset: Int,
        @Query("pageSize") pageSize: Int
    ): ArticleListResponse

    companion object {
        fun instance(): ArticleService {
            return Network.createService(ArticleService::class.java)
        }
    }

}