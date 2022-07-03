package com.noble.news.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/**
 * @author 小寒
 * @version 1.0
 * @date 2022/7/3 16:09
 */
class TaskViewModel : ViewModel() {

    var taskDate by mutableStateOf("学习周期：2022.01.01-2022.12.31")
        private set

    var pointOfYear by mutableStateOf("10000")
        private set
}