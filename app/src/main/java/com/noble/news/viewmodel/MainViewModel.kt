package com.noble.news.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.noble.news.model.entity.Category

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

    /**
     * 更新分类下标
     *
     * @param index
     */
    fun updateCategoryIndex(index: Int) {
        categoryIndex = index
    }
}