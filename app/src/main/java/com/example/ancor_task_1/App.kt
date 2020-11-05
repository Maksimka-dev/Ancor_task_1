package com.example.ancor_task_1

import android.app.Application
import com.example.ancor_task_1.model.RetrofitCreate

class App: Application() {

    var sevice = RetrofitCreate.getLatheApi()

}