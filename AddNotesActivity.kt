package com.example.sampleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleapp.databinding.ActivityAddNotesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNotesActivity : AppCompatActivity() {
    private val binding:ActivityAddNotesBinding by lazy {
        ActivityAddNotesBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    private lateinit var databaseReference:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //Initialization
        auth=FirebaseAuth.getInstance()
        databaseReference=FirebaseDatabase.getInstance().reference

        binding.saveNoteButton.setOnClickListener {
            val title=binding.title.text.toString()
            val description=binding.desription.text.toString()

            // check both has been filled
            if(title.isEmpty() && description.isEmpty()){
                Toast.makeText(this,"Please fill both the fields",Toast.LENGTH_SHORT).show()
            }else{
                // save your data (saving data for the authorised users in their separate database (with the use of "auth"))
                val currentUser=auth.currentUser
                currentUser?.let{ user ->
                    // generating a unique key for user for the Note
                    val noteKey=databaseReference.child("users").child(user.uid).child("notes").push().key
                    // NoteItem instances
                    val noteItem=NoteItem(title, description,noteKey?:"")
                    if(noteKey!=null)
                        databaseReference.child("users").child(user.uid).child("notes").child(noteKey).setValue(noteItem)
                            .addOnCompleteListener{ task ->
                                if(task.isSuccessful){
                                    Toast.makeText(this,"Successfully saved ",Toast.LENGTH_SHORT).show()
                                    startActivity(Intent(this,LogIn_SignOut_Page::class.java))
                                    finish() 
                                }else{
                                    Toast.makeText(this,"Failed to save data ${task.exception?.message}",Toast.LENGTH_SHORT).show()
                                }
                            }
                }?: run {
                    // Handle case where user is not authenticated
                    Toast.makeText(this, "User not authenticated", Toast.LENGTH_SHORT).show()
                }
            }


        }
    }
}