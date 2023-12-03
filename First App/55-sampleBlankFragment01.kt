package com.example.sampleapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.sampleapp.R
import com.example.sampleapp.databinding.FragmentBlank1Binding


class BlankFragment1 : Fragment() {
    // late initialization of binding
    private lateinit var binding:FragmentBlank1Binding
    // 55 navigation graph
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    //55 for navigation graph
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlank1Binding.inflate(inflater, container, false)

        // to perform any task by clicking on the button
        binding.button.setOnClickListener {
            navController.navigate(R.id.action_blankFragment1_to_blankFragment2)
        }
        return binding.root
    }

    companion object {
    }
}
