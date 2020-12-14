package com.example.project_wheretoeat.fragments.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.project_wheretoeat.MainViewModel
import com.example.project_wheretoeat.MainViewModelFactory
import com.example.project_wheretoeat.R
import com.example.project_wheretoeat.model.Restaurant
import com.example.project_wheretoeat.repository.Repository

class detailFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getRestaurants()


        viewModel.myResponse.observe(viewLifecycleOwner,   androidx.lifecycle.Observer{
             var myList2 = emptyList<Restaurant>()

             class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
            {
                var name = itemView.findViewById<TextView>(R.id.name_txt_detail)
                var address = itemView.findViewById<TextView>(R.id.address_txt_detail)
                var price = itemView.findViewById<TextView>(R.id.price_txt_detail)
                var country = itemView.findViewById<TextView>(R.id.country_txt_detail)
                //var image = itemView.findViewById<ImageView>(R.id.restaurant_img)

            }

                
    })

        //val id = arguments?.getInt("id")

        return view
    }



    
}