package com.example.project_wheretoeat.fragments.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.project_wheretoeat.DataBaseHandler
import com.example.project_wheretoeat.R

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
            //insert data
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
        deleteButton.setOnClickListener(){
            db?.deleteData()


        }

        //update data
        updateButton.setOnClickListener(){
            db?.updateData()
            findNavController().navigate(R.id.action_profileFragment_to_insertFragment)
        }

        //image
        /*btn_capture.setOnClickListener(){
            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent,123)
        }*/

        /*btn_gallery.setOnClickListener(){
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 456)
        }*/*/

        return view
    }

    //image
    /*override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val profileImage = requireView().findViewById<ImageView>(R.id.profile_image)
        /*if(requestCode == 123)
        {
            var bmp = data?.extras?.get("data") as Bitmap
            profileImage.setImageBitmap(bmp)
        }*/

        if (requestCode == 456)
        {
            profileImage!!.setImageURI(data?.data)
        }
    }*/

}






