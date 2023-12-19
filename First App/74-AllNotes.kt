package com.example.sampleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.databinding.ActivityAllNotesBinding
import com.example.sampleapp.databinding.DialogUpdateNoteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
//import androidx.recyclerview.widget.GridLayoutManager
//import com.google.firebase.database.*

class AllNotes : AppCompatActivity(),NoteAdapter.OnItemClickListner {
    private val binding:ActivityAllNotesBinding by lazy {
        ActivityAllNotesBinding.inflate(layoutInflater)
    }
    private lateinit var auth:FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:NoteAdapter
//    private val adapter: NoteAdapter by lazy { NoteAdapter(emptyList()) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Initialization
        auth=FirebaseAuth.getInstance()
        databaseReference=FirebaseDatabase.getInstance().reference
        recyclerView=binding.noteRecyclerView
        val adapter=NoteAdapter(emptyList(),this@AllNotes)

        val currentUser=auth.currentUser
        currentUser?.let{user->
            // Set layout manager
            // Assuming recyclerView is your RecyclerView instance
//            val layoutManager = GridLayoutManager(this, 2)
//            recyclerView.layoutManager = layoutManager

            val layoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = layoutManager

            // set Adapter
            recyclerView.adapter = adapter

            val noteReference=databaseReference.child("users").child(user.uid).child("notes")
            noteReference.addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val noteList= mutableListOf<NoteItem>()
//                    noteList.clear()
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

    override fun onDeleteClick(noteId: String) {
        Log.d("AllNotes", "onDeleteClick called for noteId: $noteId")

        val currentUser=auth.currentUser
        currentUser?.let { user->
            val noteRefrence=databaseReference.child("users").child(user.uid).child("notes")
            noteRefrence.child(noteId).removeValue()
//            Log.e("AllNotes", "Data Retrieval Failed: ${error.message}" )
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Note deleted successfully", Toast.LENGTH_SHORT).show()
//                        Log.d("AllNotes", "Note deleted successfully")
//                        Log.e("AllNotes", "Failed to delete note: $errorMessage", task.exception)
                    } else {
                        Toast.makeText(this, "Failed to delete note ", Toast.LENGTH_SHORT).show()
                        Log.e("AllNotes", "Failed to delete note", task.exception)
                    }
                }
        }
    }



    override fun onUpdateClick(noteId: String,currentTitle: String,currentDescription: String) {
        val dialogBinding=DialogUpdateNoteBinding.inflate(LayoutInflater.from(this))
        val dialog=AlertDialog.Builder(this).setView(dialogBinding.root)
            .setTitle("updateNotes")
            .setPositiveButton("update"){dialog,_ ->
                val newTitle=dialogBinding.updateTitle.text.toString()
                val newDescription=dialogBinding.updateDescription.text.toString()
                updateNoteDatabase(noteId,newTitle,newDescription)
                dialog.dismiss()
            }
            .setNegativeButton("Cancel1"){dialog,_ ->
                dialog.dismiss()
            }
            .create()
        dialogBinding.updateDescription.setText(currentDescription)
        dialogBinding.updateTitle.setText(currentTitle)
        dialog.show()



    }

    private fun updateNoteDatabase(noteId: String, newTitle: String, newDescription: String) {
        val currentUser=auth.currentUser
        currentUser?.let { user ->
            val noteReference=databaseReference.child("users").child(user.uid).child("notes")
            val updateNote=NoteItem(newTitle,newDescription,noteId)
            noteReference.child(noteId).setValue(updateNote)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(this,"Update done successfully ",Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this,"Failed to save data ",Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }


}
