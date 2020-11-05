package com.example.ancor_task_1.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import com.bumptech.glide.Glide
import com.example.ancor_task_1.R
import com.example.ancor_task_1.model.LatheApi

class DeteilFragment: Fragment() {

    private lateinit var model: TextView
    private lateinit var producer: TextView
    private lateinit var machineLocation: TextView
    private lateinit var diameter: TextView
    private lateinit var lengthMax: TextView
    private lateinit var condition1: TextView
    private lateinit var image: ImageView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.lathe_details_fragment, container, false)

        model = rootView.findViewById(R.id.textViewModelName)
        producer = rootView.findViewById(R.id.textViewProducer)
        machineLocation = rootView.findViewById(R.id.textViewLocation)
        diameter = rootView.findViewById(R.id.textViewDiameter)
        lengthMax = rootView.findViewById(R.id.textViewMaxLength)
        condition1 = rootView.findViewById(R.id.textViewCondition)
        image = rootView.findViewById(R.id.imageViewLathe)

        parentFragmentManager.setFragmentResultListener("requestKey",this) { key, bundle ->
            val request = LatheApi(bundle.getString("model")!!,bundle.getString("producer")!!,
                bundle.getString("machineLocation")!!,bundle.getString("diameter")!!,bundle.getString("lengthMax")!!,
                bundle.getString("condition1")!!,bundle.getString("video1")!!)

            Glide
                .with(requireActivity())
                .load(request.imageUrl)
                .centerCrop()
                .error(R.drawable.nophoto)
                .into(image)

            model.text = request.model
            producer.text = request.producer
            machineLocation.text = request.machineLacation
            diameter.text = request.diameter
            lengthMax.text = request.lengthMax
            condition1.text = request.condition
        }

        return rootView
    }
}