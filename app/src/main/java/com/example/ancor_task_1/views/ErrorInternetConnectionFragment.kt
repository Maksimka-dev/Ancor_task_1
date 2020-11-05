package com.example.ancor_task_1.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.ancor_task_1.R

class ErrorInternetConnectionFragment: Fragment() {

    private lateinit var imageView: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.error_internet_connection_fragment, container, false)

        imageView = rootView.findViewById(R.id.imageViewErrorInternet)

        Glide
            .with(this.requireActivity())
            .load(R.drawable.maxresdefault)
            .fitCenter()
            .into(imageView)

        return rootView
    }

}