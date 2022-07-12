package com.noble.news.model.service

import com.noble.news.model.Network
import com.noble.news.model.entity.UserInfoResponse
import com.noble.news.model.entity.VideoInfoResponse
import retrofit2.http.*

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/12 17:29
 */
interface UserService {

    @FormUrlEncoded
    @POST("user/signIn")
    suspend fun signIn(
        @Field("userName") userName: String,
        @Field("password") password: String
    ): UserInfoResponse

    companion object {
        fun instance(): UserService {
            return Network.createService(UserService::class.java)
        }
    }

}