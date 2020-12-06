package com.example.project_wheretoeat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_insert.view.*

class InsertFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_insert, container, false)


        val insertButton: Button = view.findViewById<Button>(R.id.btn_insert)

        val name: EditText = view.findViewById<EditText>(R.id.addName)
        val address: EditText = view.findViewById<EditText>(R.id.addAddress)
        val phone_number: EditText = view.findViewById<EditText>(R.id.addPhoneNumber)
        val email: EditText = view.findViewById<EditText>(R.id.addEmail)

        var db = context?.let { DataBaseHandler(context = it) }

        //insert data
        fun insert() {
            if (name.text.toString().length > 0 &&
                address.text.toString().length > 0 &&
                phone_number.text.toString().length > 0 &&
                email.text.toString().length > 0) {
                var user = User(name.text.toString(), address.text.toString(), phone_number.text.toString().toInt(), email.text.toString())

                db?.insertData(user)
            }
        }


        insertButton.setOnClickListener({
            insert()
        })

        return view
    }


}