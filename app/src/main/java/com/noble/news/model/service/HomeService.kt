package com.noble.news.model.service

import com.noble.news.model.Network
import com.noble.news.model.entity.CategoryResponse
import com.noble.news.model.entity.SwiperResponse
import retrofit2.http.GET

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/10 16:45
 */
interface HomeService {

    @GET("category/list")
    suspend fun category(): CategoryResponse

    @GET("recommand/banner")
    suspend fun banner(): SwiperResponse

    companion object {
        fun instance(): HomeService {
            return Network.createService(HomeService::class.java)
        }
    }

}