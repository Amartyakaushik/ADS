package com.example.lpuliveclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lpuliveclone.R
import com.example.lpuliveclone.RvModel
import com.example.lpuliveclone.adapter.RvAdapter
import com.example.lpuliveclone.databinding.FragmentHomePageBinding

class HomePage : Fragment() {
    private lateinit var binding:FragmentHomePageBinding
    private lateinit var rvAdapter: RvAdapter
    private lateinit var dataList: ArrayList<RvModel>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=FragmentHomePageBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataList=ArrayList<RvModel>()
        rvAdapter= RvAdapter(dataList, requireContext())
        binding.rv.layoutManager=LinearLayoutManager(requireContext())
//        binding.rv.layoutManager=GridLayoutManager(requireContext(),4)
        binding.rv.adapter=rvAdapter

    }

//    companion object {
//    }
}