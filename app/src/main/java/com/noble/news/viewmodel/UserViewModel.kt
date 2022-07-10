package com.noble.news.viewmodel

import androidx.lifecycle.ViewModel
import com.noble.news.model.entity.UserInfoEntity

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/10 15:05
 */
class UserViewModel : ViewModel() {

    var userInfo: UserInfoEntity? = null
        private set

    //是否已登录
    val logged: Boolean
        get() {
            return userInfo != null
        }

    /**
     * 登录操作
     */
    fun login(onClose: () -> Unit) {
        //模拟网络请求数据回传
        userInfo = UserInfoEntity("user001")
        onClose()
    }

}