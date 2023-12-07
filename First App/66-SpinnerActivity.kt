package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class SpinnerActivity : AppCompatActivity() {
    private  lateinit var spinner:Spinner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spinner)

//        spinner=findViewById(R.id.spinner)
        spinner=findViewById(R.id.spinner)
        val spinnerList= listOf("Apple 🍎","Bannana 🍌","kiwi 🥝","PineApple 🍍")

        val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,spinnerList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter=arrayAdapter


        spinner.onItemSelectedListener=object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val selectedItem=parent?.getItemAtPosition(position).toString()
                Toast.makeText(this@SpinnerActivity,"You selected $selectedItem",Toast.LENGTH_LONG).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }
    }
}
