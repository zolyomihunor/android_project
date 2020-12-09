package com.example.project_wheretoeat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project_wheretoeat.R
import com.example.project_wheretoeat.model.Restaurant
import kotlinx.android.synthetic.main.list_row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Restaurant>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var name = itemView.findViewById<TextView>(R.id.name_txt)
        var address = itemView.findViewById<TextView>(R.id.address_txt)
        var price = itemView.findViewById<TextView>(R.id.price_txt)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_row_layout,parent,false))

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = myList[position]
        holder.name.text = currentItem.name
        holder.address.text = currentItem.address
        holder.price.text = currentItem.price.toString()
    }

    fun setData(newList: List<Restaurant>)
    {
        this.myList = newList
        notifyDataSetChanged()
    }
}

