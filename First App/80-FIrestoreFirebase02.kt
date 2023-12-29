package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.databinding.ActivityFirebaseFirestore02Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseFirestore02 : AppCompatActivity() {
    private lateinit var binding:ActivityFirebaseFirestore02Binding
    private lateinit var rvAdapter:RvAdapter
    private var list= arrayListOf<user>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFirebaseFirestore02Binding.inflate(layoutInflater)
        setContentView(binding.root)


        rvAdapter=RvAdapter(this,list)
        val linearlayout=LinearLayoutManager(this)
        binding.recyclerView.layoutManager=linearlayout
//        binding.recyclerView.layoutManager=LinearLayoutManager(this)
//        val gridLayoutManager = GridLayoutManager(this, 1) // 2 columns
//        binding.recyclerView.layoutManager = gridLayoutManager
        binding.recyclerView.adapter=rvAdapter

        fetchDataFromFirestore()
    }

    private fun fetchDataFromFirestore() {
        val db=Firebase.firestore
        db.collection("Users")
            .get()
            .addOnSuccessListener { result->
                list.clear()
                for(document in result){
                    val user=document.toObject(user::class.java)
                    user?.let {
                        user.id=document.id
                        list.add(it)
                        Log.d("user file", "data Retrieved: $it")
                    }
//                    user.id=document.id
//                    list.add(user)
                }
                list.reverse()
                logUserListSize()
                rvAdapter.notifyDataSetChanged()

                for (user in list) {
                    Log.d("FirebaseFirestore02", "User: ${user.name}, ${user.pass}, ${user.id}")
                }

            }
            .addOnFailureListener { exception ->
                exception.printStackTrace()
            }
    }

    private fun logUserListSize() {
        Log.d("FirebaseFirestore002", "UserList size: ${list.size}")
    }
}
