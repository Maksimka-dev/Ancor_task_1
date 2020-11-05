package com.example.ancor_task_1

import com.example.ancor_task_1.model.LatheApi

interface MainContract {
    interface View {
        fun setItems(items: List<LatheApi>)
    }
}