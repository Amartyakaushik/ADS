package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demo.databinding.ActivityFirebaseFirestore02Binding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseFirestore02 : AppCompatActivity() {
    private lateinit var binding:ActivityFirebaseFirestore02Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFirebaseFirestore02Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val db=Firebase.firestore
        var list= arrayListOf<user>()
        var rvAdapter=RvAdapter(this,list)
        binding.recyclerView.layoutManager=LinearLayoutManager(this)
        binding.recyclerView.adapter=rvAdapter
        db.collection("Users")
            .get()
            .addOnSuccessListener { result->
                list.clear()
                for(document in result){
                    var user=document.toObject(user::class.java)
                    user.id=document.id
                    list.add(user)
                }
                rvAdapter.notifyDataSetChanged()

            }
    }
}
