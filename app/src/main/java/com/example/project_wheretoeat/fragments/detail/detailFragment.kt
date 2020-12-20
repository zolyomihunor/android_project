package com.example.project_wheretoeat.fragments.detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_wheretoeat.MainViewModel
import com.example.project_wheretoeat.MainViewModelFactory
import com.example.project_wheretoeat.R
import com.example.project_wheretoeat.model.Restaurant
import com.example.project_wheretoeat.repository.Repository
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_detail.view.*
import org.w3c.dom.Text

class detailFragment : Fragment() {

    private val args: detailFragmentArgs by navArgs()

    private lateinit var viewModel: MainViewModel

    //var myList2 = emptyList<Restaurant>()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_detail, container, false)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getOneRestaurant(args.id)



        viewModel.myRestaurant.observe(viewLifecycleOwner, Observer{response_restaurant ->


            val currentItem = response_restaurant

            val name=view?.findViewById<TextView>(R.id.name_txt_detail)
            val address=view?.findViewById<TextView>(R.id.address_txt_detail)
            val price=view?.findViewById<TextView>(R.id.price_txt_detail)
            val country=view?.findViewById<TextView>(R.id.country_txt_detail)
            val area = view?.findViewById<TextView>(R.id.area_txt_detail)
            val city = view?.findViewById<TextView>(R.id.city_txt_detail)
            val state = view?.findViewById<TextView>(R.id.state_txt_detail)
            val postal_code = view?.findViewById<TextView>(R.id.postalcode_txt_detail)
            val reserve_url = view?.findViewById<TextView>(R.id.reserveurl_txt_detail)
            val image = view?.findViewById<ImageView>(R.id.restaurant_img_detail)

            name.setText(response_restaurant.name)

            name.setText(currentItem.name)
            address.setText(currentItem.address)
            price.setText(currentItem.price.toString())
            country.setText(currentItem.country)
            area.setText(currentItem.area)
            city.setText(currentItem.city)
            state.setText(currentItem.state)
            postal_code.setText(currentItem.postal_code)
            reserve_url.setText(currentItem.reserve_url)
            Glide.with(image.context).load(currentItem.image_url).into(image).view


            //map
            val gps=view?.findViewById<ImageButton>(R.id.gps_detail)
            val lat = requireArguments().get("lat").toString()
            val lng = requireArguments().get("lng").toString()
            gps.setOnClickListener{
                val uri = Uri.parse("geo:$lat,$lng")
                val mapIntent = Intent(Intent.ACTION_VIEW, uri)
                mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)
            }

            //phone call
            val phone_call = view?.findViewById<ImageButton>(R.id.phone_detail)
            val phone = requireArguments().get("phone").toString()
            phone_call.setOnClickListener{
                val uri1 = Uri.parse("tel:$phone")
                val callIntent = Intent(Intent.ACTION_DIAL, uri1)
                callIntent.setData(uri1)
                startActivity(callIntent)
            }

        })







        return view
    }

}

            /*holder.name.text = currentItem.name
            holder1.address.text = currentItem.address
            holder2.price.text = currentItem.price.toString()
            holder3.country.text = currentItem.country


            class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
            {
                //var name = itemView.findViewById<TextView>(R.id.name_txt_detail)
                var address = itemView.findViewById<TextView>(R.id.address_txt_detail)
                var price = itemView.findViewById<TextView>(R.id.price_txt_detail)
                var country = itemView.findViewById<TextView>(R.id.country_txt_detail)
                //var image = itemView.findViewById<ImageView>(R.id.restaurant_img)
            }

            fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val currentItem = myList2[position]
                holder.name.text = currentItem.name
                holder.address.text = currentItem.address
                holder.price.text = currentItem.price.toString()
                holder.country.text = currentItem.country
                //Glide.with(holder.itemView.context).load(currentItem.image_url).into(holder.image).view
            }
            fun setData(newList: List<Restaurant>)
            {
                this.myList2 = newList
                //notifyDataSetChanged()
            }

            setData(response)*/


        //val id = arguments?.getInt("id")





