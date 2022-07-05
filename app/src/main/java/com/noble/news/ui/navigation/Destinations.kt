package com.noble.news.ui.navigation

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/5 10:37
 */
sealed class Destinations(val route: String) {
    //首页大框架
    object HomeFrame : Destinations("HomeFrame")

    //文章详情页
    object ArticleDetail : Destinations("ArticleDetail")
}
