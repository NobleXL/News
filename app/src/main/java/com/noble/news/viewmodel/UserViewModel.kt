package com.noble.news.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noble.news.model.service.UserInfoManager
import com.noble.news.model.entity.UserInfoEntity
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/10 15:05
 */
class UserViewModel(context: Context) : ViewModel() {

    private val userInfoManager = UserInfoManager(context = context)

    var userInfo: UserInfoEntity? = null
        private set

    init {
        // 这里可以使用 DataStore 的对象存储，直接存储整个对象
        viewModelScope.launch {
            val userName = userInfoManager.userName.firstOrNull()
            userInfo = if (userName?.isNotEmpty() == true) {
                UserInfoEntity(userName)
            } else {
                null
            }
        }
    }

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
        viewModelScope.launch {
            userInfoManager.save("user001")
        }
        onClose()
    }

    fun clear() {
        viewModelScope.launch {
            userInfoManager.clear() //清除本地数据存储
            userInfo = null //置空内存数据
        }
    }

}