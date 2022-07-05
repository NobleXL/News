package com.noble.news.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.noble.news.model.entity.NavigationItem

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/6/30 18:32
 */

@Composable
fun MainFrame(onNavigateToArticle: () -> Unit = {}) {

    val navigationItems = listOf(
        NavigationItem(title = "学习", icon = Icons.Filled.Home),
        NavigationItem(title = "任务", icon = Icons.Filled.DateRange),
        NavigationItem(title = "我的", icon = Icons.Filled.Person),
    )

    var currentNavigationIndex by remember {
        mutableStateOf(0)
    }

    ProvideWindowInsets {
        Scaffold(bottomBar = {
            BottomNavigation(
                backgroundColor = MaterialTheme.colors.surface,
                modifier = Modifier.navigationBarsPadding()
            ) {
                navigationItems.forEachIndexed { index, navigationItem ->
                    BottomNavigationItem(
                        selected = currentNavigationIndex == index,
                        onClick = {
                            currentNavigationIndex = index
                        },
                        //直接考试结果页面，进入查看页面，返回直接回到列表？
                        icon = {
                            Icon(
                                imageVector = navigationItem.icon,
                                contentDescription = null
                            )
                        },
                        label = {
                            Text(text = navigationItem.title)
                        },
                        selectedContentColor = Color(0xFF149EE7),
                        unselectedContentColor = Color(0xFF999999)
                    )
                }
            }
        }) {
            Box(modifier = Modifier.padding(it)) {
                when (currentNavigationIndex) {
                    0 -> StudyScreen(onNavigateToArticle = onNavigateToArticle)
                    1 -> TaskScreen()
                    2 -> MineScreen()
                }
            }
        }
    }

}

@Preview
@Composable
fun MainFramePreview() {
    MainFrame()
}

