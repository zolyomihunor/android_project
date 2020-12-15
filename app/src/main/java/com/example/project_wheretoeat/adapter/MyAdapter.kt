package com.example.project_wheretoeat.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_wheretoeat.MainActivity
import com.example.project_wheretoeat.R
import com.example.project_wheretoeat.fragments.detail.detailFragment
import com.example.project_wheretoeat.fragments.main.mainFragment
import com.example.project_wheretoeat.fragments.main.mainFragmentDirections
import com.example.project_wheretoeat.model.Restaurant
import kotlinx.android.synthetic.main.list_row_layout.view.*

class MyAdapter: RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Restaurant>()

    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        var name = itemView.findViewById<TextView>(R.id.name_txt)
        var address = itemView.findViewById<TextView>(R.id.address_txt)
        var price = itemView.findViewById<TextView>(R.id.price_txt)
        var country = itemView.findViewById<TextView>(R.id.country_txt)
        var image = itemView.findViewById<ImageView>(R.id.restaurant_img)

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
        holder.country.text = currentItem.country
        Glide.with(holder.itemView.context).load(currentItem.image_url).into(holder.image).view

        //rakattintas
        /*val fragmentDetail = detailFragment()
        val bundle:Bundle = Bundle()
        bundle.putInt("id", myList[position].id)
        fragmentDetail.arguments=bundle;*/

        holder.itemView.restaurant_image.setOnClickListener{
            val action = mainFragmentDirections.actionMainFragmentToDetailFragment(currentItem.id)
            holder.itemView.findNavController().navigate(action)
        }



        /*holder.itemView.restaurant_image.setOnClickListener{
            holder.itemView.findNavController().navigate(R.id.action_mainFragment_to_detailFragment)
        }*/
    }

    fun setData(newList: List<Restaurant>)
    {
        this.myList = newList
        notifyDataSetChanged()
    }


    //rakattintas
    /* fun onItemClick(position: Int)
    {
        val fragmentDetail = detailFragment()
        val bundle:Bundle = Bundle()
        bundle.putInt("id", myList[position].id)
        fragmentDetail.arguments=bundle;
        (activity as MainActivity).supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment, fragmentDetail)
            commit()
        }
    }*/
}

