package com.example.project_wheretoeat.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.project_wheretoeat.DataBaseHandler
import com.example.project_wheretoeat.InsertFragment
import com.example.project_wheretoeat.R
import com.example.project_wheretoeat.User

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [profileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class profileFragment : Fragment() {


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_profile, container, false)


        val insertButton: Button = view.findViewById<Button>(R.id.btn_insert)
        val deleteButton: Button = view.findViewById<Button>(R.id.btn_delete)
        val updateButton: Button = view.findViewById<Button>(R.id.btn_update)


        val data_profile = view.findViewById<TextView>(R.id.data_profile)

        var db = context?.let { DataBaseHandler(context = it) }

        insertButton.setOnClickListener{
            //insert()
            findNavController().navigate(R.id.action_profileFragment_to_insertFragment)
        }



        //read data
        var data = db?.readData()
        data_profile.text = ""
        if(data != null)
        {
            for (i in 0..(data.size-1))
            {
                data_profile.append("\nName: " + data.get(i).name + "\n\nAdress: "
                        + data.get(i).address + "\n\nPhone Number:  " + data.get(i).phone_number + "\n\nEmail:  " + data.get(i).email + "\n")
            }
        }

        if(data_profile.text == "")
        {
            data_profile.append("You have no data to display yet. \n\n Please enter your details!")
        }

        //delete data
        deleteButton.setOnClickListener({
            db?.deleteData()
        })

        //update data
        updateButton.setOnClickListener({
            db?.updateData()
        })

        return view
    }





}