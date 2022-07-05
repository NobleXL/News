package com.noble.news.ui.components

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.noble.news.ui.navigation.Destinations
import com.noble.news.ui.screens.ArticleDetailScreen
import com.noble.news.ui.screens.MainFrame

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/5 10:41
 *
 * 导航控制器
 */
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavHostApp() {

    val navController = rememberAnimatedNavController()
    ProvideWindowInsets {
        AnimatedNavHost(
            navController = navController,
            startDestination = Destinations.HomeFrame.route
        ) {
            //首页大框架
            composable(
                Destinations.HomeFrame.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentScope.SlideDirection.Right)
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentScope.SlideDirection.Left)
                }) {
                MainFrame(onNavigateToArticle = {
                    navController.navigate(Destinations.ArticleDetail.route)
                })
            }

            //文章详情页
            composable(
                Destinations.ArticleDetail.route,
                enterTransition = {
                    slideIntoContainer(AnimatedContentScope.SlideDirection.Left)
                },
                exitTransition = {
                    slideOutOfContainer(AnimatedContentScope.SlideDirection.Right)
                }) {
                ArticleDetailScreen(onBack = {
                    navController.popBackStack()
                })
            }
        }
    }
}

@Preview
@Composable
fun NavHostAppPreview() {
    NavHostApp()
}

