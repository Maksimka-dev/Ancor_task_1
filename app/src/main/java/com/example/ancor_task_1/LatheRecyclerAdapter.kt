package com.example.ancor_task_1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ancor_task_1.model.LatheApi


class LatheRecyclerAdapter(private val context: Context, private var listener: OnItemClickListener): RecyclerView.Adapter<LatheHolder>() {

    private val item = mutableListOf<LatheApi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LatheHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lathe_holder, parent, false)
        return LatheHolder(view, context)
    }

    override fun onBindViewHolder(holder: LatheHolder, position: Int) {

        if (position != RecyclerView.NO_POSITION) {
            val image = item[position].imageUrl
            val title = item[position].model
            holder.initialise(item, listener)
            holder.bindImage(image)
            holder.bindTitle(title)
        }
    }

    override fun getItemCount(): Int {
        return item.size
    }

    fun addItems(newItems: List<LatheApi>){
        item.addAll(newItems)
        notifyDataSetChanged()
    }

}
class LatheHolder(itemView: View, private val context: Context): RecyclerView.ViewHolder(itemView) {

    private val image = itemView.findViewById<ImageView>(R.id.imageView)
    private val text = itemView.findViewById<TextView>(R.id.textView)

    fun initialise(item: List<LatheApi>, action: OnItemClickListener){
        itemView.setOnClickListener {
            action.onItemClick(item[adapterPosition], adapterPosition )
        }
    }

    fun bindImage(url: String) {

        Glide
            .with(context)
            .load(url)
            .error(R.drawable.ic_baseline_broken_image_24)
            .into(image)

    }

    fun bindTitle(title: String){

        text.text = title

    }
}

interface OnItemClickListener{
    fun onItemClick(item: LatheApi, position: Int)
}