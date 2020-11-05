package com.example.ancor_task_1.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ancor_task_1.R

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        selectFragment(LIST_FRAGMENT)

    }

    fun selectFragment(numberFragment: String){

        if (numberFragment == LIST_FRAGMENT){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.LatheFrame, ListFragment())
                .commit()
        }

        if (numberFragment == DETAIL_FRAGMENT){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.LatheFrame, DeteilFragment())
                .addToBackStack(null)
                .commit()
        }

        if (numberFragment == ERROR_INTERNET_CONNECTOIN_FRAGMENT){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.LatheFrame, ErrorInternetConnectionFragment())
                .commit()

        }

    }

    companion object{
        const val LIST_FRAGMENT = "1"
        const val DETAIL_FRAGMENT = "2"
        const val ERROR_INTERNET_CONNECTOIN_FRAGMENT = "3"
    }
}