package com.example.ancor_task_1.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ancor_task_1.*
import com.example.ancor_task_1.model.LatheApi
import com.example.ancor_task_1.presenters.ListPresenter

class ListFragment : Fragment(), MainContract.View, OnItemClickListener {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: LatheRecyclerAdapter
    private lateinit var listPresenter: ListPresenter

    private var isFirstAdd: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listPresenter = ListPresenter(this)
        recyclerAdapter = LatheRecyclerAdapter(this.requireActivity(),this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView = inflater.inflate(R.layout.lathe_list_fragment, container, false)

        recyclerView = rootView.findViewById(R.id.LatheList)
        recyclerView.layoutManager = GridLayoutManager(this.requireActivity(),2)
        recyclerView.adapter = recyclerAdapter

        if (Network.isNetworkAvailable(this.requireActivity() as MainActivity)) {

            if (!isFirstAdd){
                listPresenter.makeRequest()
                isFirstAdd = true
            }


        }else {

            (this.requireActivity() as MainActivity).selectFragment(MainActivity.ERROR_INTERNET_CONNECTOIN_FRAGMENT)

        }

        return rootView
    }

    override fun setItems(items: List<LatheApi>) {
        recyclerAdapter.addItems(items)
    }

    override fun onItemClick(item: LatheApi, position: Int) {
        parentFragmentManager.setFragmentResult("requestKey",
            bundleOf("model" to item.model, "producer" to item.producer, "machineLocation" to item.machineLacation,
                "diameter" to item.diameter, "lengthMax" to item.lengthMax, "condition1" to item.condition, "video1" to item.imageUrl))
        (requireActivity() as MainActivity).selectFragment(MainActivity.DETAIL_FRAGMENT)
    }
}