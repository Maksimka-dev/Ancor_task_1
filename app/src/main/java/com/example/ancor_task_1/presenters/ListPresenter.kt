package com.example.ancor_task_1.presenters

import com.example.ancor_task_1.App
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListPresenter(listFragment: com.example.ancor_task_1.views.ListFragment) {

    private val fragment = listFragment

    fun makeRequest(){

            CoroutineScope(Dispatchers.IO).launch {
                val response = (fragment.requireActivity().application as App).sevice.getLathe()
                withContext(Dispatchers.Main) {
                    if (response.isSuccessful) {
                        fragment.setItems(response.body()!!)
                    }
                }
            }

    }


}