package com.noble.news.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.SmartDisplay
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.noble.news.model.entity.Category
import com.noble.news.model.entity.DataType

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/1 11:09
 */
class MainViewModel : ViewModel() {

    //分类数据
    val categories by mutableStateOf(
        listOf(
            Category("思想政治"),
            Category("法律法规"),
            Category("职业道德"),
            Category("诚信自律")
        )
    )

    //当前分类下标
    var categoryIndex by mutableStateOf(0)
        private set

    /**
     * 更新分类下标
     *
     * @param index
     */
    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }

    //类型数据
    val types by mutableStateOf(
        listOf(
            DataType("相关资讯", Icons.Default.Description),
            DataType("视频课程", Icons.Default.SmartDisplay)
        )
    )

    // 当前类型下标
    var currentTypeIndex by mutableStateOf(0)
        private set

    /**
     * 更新类型下标
     *
     * @param index
     */
    fun updateTypeIndex(index: Int) {
        currentTypeIndex = index
    }
}