package com.noble.news.model.entity

import androidx.compose.ui.graphics.vector.ImageVector

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/6/30 18:34
 */
/**
 * 导航栏对象
 *
 * @property title  导航栏的标题
 * @property icon 导航栏图标
 */
data class NavigationItem(
    val title: String, //底部导航栏的标题
    val icon: ImageVector//底部导航栏图标
)
