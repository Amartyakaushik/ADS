package com.example.sampleapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {
    // late initialization of binding
    private lateinit var binding:FragmentBlank1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank1Binding.inflate(inflater, container, false)

        // to perform any task by clicking on the button
        binding.button.setOnClickListener {
            Toast.makeText(context,"Hello",Toast.LENGTH_LONG).show()
        }
        return binding.root
    }

    companion object {
    }
}