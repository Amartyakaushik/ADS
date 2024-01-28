package com.example.lpuliveclone.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lpuliveclone.R
import com.example.lpuliveclone.databinding.FragmentBottomNavBarBinding
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.material.navigation.NavigationBarView


class BottomNavBar : Fragment() {
    private lateinit var binding: FragmentBottomNavBarBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController=Navigation.findNavController(view)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bottom_nav_bar, container, false)
        binding = FragmentBottomNavBarBinding.bind(view)


        val homePage=HomePage()
        val notify=Notify()
        binding.bottomBar.setOnItemReselectedListener(NavigationBarView.OnItemReselectedListener {
            when(it.itemId){
                R.id.tab_home -> navController.navigate(R.id.action_bottomNavBar_to_homePage)
                R.id.tab_notify -> navController.navigate(R.id.action_bottomNavBar_to_notify)
            }
        })
//        {
//            when(it.itemId){
//                R.id.tab_home -> replaceFragment(homePage)
//                R.id.tab_notify -> replaceFragment(notify)
//
//            }
            true

//        binding.bottomBar.setOnItemSelectListener(object: OnItemSelectedListener{
//            override fun onItemSelected(position: Int ){
//                when (position){
//                    0 -> replaceFragment(HomePage())
//                    1 -> replaceFragment(Notify())
//
////                    1 -> {
////                        navController.navigate(R.id.action_bottomNavBar_to_notify)
////                    }
//
//                }
//            }
//        })
        return  view
    }
//    private fun setCurrentFragment(fragment:Fragment)=
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_view,fragment)
//            commit()
//        }

    private fun replaceFragment(fragment: Fragment) {
//        val manager=supportFragmentManager
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_view, fragment)
        transaction.addToBackStack(null) // Optional: Add to back stack if you want to navigate back
        transaction.commit()

    }

//    companion object {
//    }
}