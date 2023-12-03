package com.example.sampleapp.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.sampleapp.R

class BlankFragment_LC_1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG", "onCreate: ")
        Toast.makeText(requireContext(),"onCreate:viewCreated",Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank__l_c_1, container, false)
        Log.d("TAG", "onCreateView: ")
        Toast.makeText(requireContext(),"onCreateView:viewCreated",Toast.LENGTH_SHORT).show()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("TAG", "onAttach: ")
        Toast.makeText(requireContext(),"onAttach:viewCreated",Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("TAG", "onViewCreated: ")
        Toast.makeText(requireContext(),"onViewCreated:viewCreated",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: ")
        Toast.makeText(requireContext(),"onResume:viewCreated",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause: ")
        Toast.makeText(requireContext(),"onPause:viewCreated",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop: ")
        Toast.makeText(requireContext(),"onStop:viewCreated",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy: ")
        Toast.makeText(requireContext(),"onDestroy:viewCreated",Toast.LENGTH_SHORT).show()
    }
}