package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.databinding.ActivityAllNotesBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.*

class AllNotes : AppCompatActivity() {
    private val binding:ActivityAllNotesBinding by lazy {
        ActivityAllNotesBinding.inflate(layoutInflater)
    }
    private lateinit var auth:FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private val adapter: NoteAdapter by lazy { NoteAdapter(emptyList()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialization
        auth=FirebaseAuth.getInstance()
        databaseReference=FirebaseDatabase.getInstance().reference
        recyclerView=binding.noteRecyclerView

        val currentUser=auth.currentUser
        currentUser?.let{user->
            // Set layout manager
            // Assuming recyclerView is your RecyclerView instance
            val layoutManager = GridLayoutManager(this, 2)
            recyclerView.layoutManager = layoutManager

//            val layoutManager = LinearLayoutManager(this)
//            recyclerView.layoutManager = layoutManager



            // set Adapter
            recyclerView.adapter = adapter

            val noteReference=databaseReference.child("users").child(user.uid).child("notes")
            noteReference.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val noteList= mutableListOf<NoteItem>()
                    noteList.clear()
                    for(noteSnapshot in snapshot.children){
                        val note=noteSnapshot.getValue(NoteItem::class.java)
                        note?.let{
                            noteList.add(it)
                            Log.d("AllNotes", "Note Retrieved: $it")
                        }
                    }
                    noteList.reverse()

                    // Attach adapter to the recylcler view
                    adapter.updateData(noteList)
                    Log.d("All Notes", "Data Retrieved $noteList")
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.e("AllNotes", "Data Retrieval Failed: ${error.message}" )
                }

            })
        }
    }
}
