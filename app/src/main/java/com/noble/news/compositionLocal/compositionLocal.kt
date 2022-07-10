package com.noble.news.compositionLocal

import androidx.compose.runtime.compositionLocalOf
import com.noble.news.viewmodel.UserViewModel

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/10 15:11
 */
val LocalUserViewModel =
    compositionLocalOf<UserViewModel> { error("User View Model Context Not Found") }