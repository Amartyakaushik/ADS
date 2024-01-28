package com.example.lpuliveclone.BottomNavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.lpuliveclone.Fragments.HomePage
import com.example.lpuliveclone.Fragments.Notify
import com.example.lpuliveclone.R
import com.example.lpuliveclone.databinding.ActivityBottomNavBarBinding

class BottomNav_Bar : AppCompatActivity() {
    private lateinit var binding:ActivityBottomNavBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityBottomNavBarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homePage=HomePage()
        val notify=Notify()
        setCurrentFragment(homePage)

        binding.bottomBar.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.tab_home -> setCurrentFragment(homePage)
                R.id.tab_notify -> setCurrentFragment(notify)
            }
            true
        }
//        binding.bottomBar.setOnItemSelectListener(object : OnItemSelectedListener{
//             override fun onItemSelected(position : Int, item: BottomNavBar){
//                 when(position){
//                     0 -> {
//                         val intent = Intent(this,HomePage::class.java)
//                         startActivity(intent)
//                     }
//                 }
//
//            }
//        })


    }

    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.fragment_view,fragment)
            commit()

    }

//    private fun setCurrentFragment(fragment: Fragment)=
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_view,fragment)
//            commit()
//        }
}

//when (pos){
//    0 -> {
//        val intent = Intent(this,HomePage::class.java)
//        startActivity(intent)
//    }
//    1 -> {
//        val intent = Intent(this,HomePage::class.java)
//        startActivity(intent)
//    }
//    2 -> {
//        val intent = Intent(this,HomePage::class.java)
//        startActivity(intent)
//    }
//    else -> {
//        Log.e("TAG", "${error(e.message)})" )
//    }
//}