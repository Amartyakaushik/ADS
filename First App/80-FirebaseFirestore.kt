package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.sampleapp.databinding.ActivityFirebaseFirestoreBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class FirebaseFirestore : AppCompatActivity() {
    private lateinit var binding:ActivityFirebaseFirestoreBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityFirebaseFirestoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db= Firebase.firestore
        binding.logInBtn.setOnClickListener{
//            check if both email and password is filled
            val email=binding.inputEmail.text.toString()
            val pass=binding.inputPass.text.toString()
            if(email.isEmpty() || pass.isEmpty()){
                Toast.makeText(this,"Both fields must be filled.",Toast.LENGTH_LONG).show()
            }
            else{
                val currentUser= FirebaseAuth.getInstance().currentUser
//                check if any authenticated user is trying to write any data to the FireStore Database.
                if(currentUser !=null){

                val user= hashMapOf(
                    "name" to email,
                    "pass" to pass
                )

                db.collection("Users")
                    .add(user)
                    .addOnSuccessListener { documentReference ->
                        Toast.makeText(this,"DocumentSnapshot added with Id:${documentReference.id}",Toast.LENGTH_LONG).show()
                    }
                    .addOnFailureListener { e->
                        Log.w("TAG", "Error adding document: ", e)
//                        Toast.makeText(this,"Failed to add DocumentSnapshot : ${e.localizedMessage}",Toast.LENGTH_LONG).show()
                    }
                }
//                check if user is authenticated or not
                else{
                    Toast.makeText(this, "User not authenticated ", Toast.LENGTH_LONG).show()
                }
            }


        }
    }
}
