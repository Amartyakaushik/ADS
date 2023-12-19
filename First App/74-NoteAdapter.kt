package com.example.sampleapp

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.databinding.NotesitemBinding
//import android.widget.AdapterView.OnItemClickListener

class NoteAdapter(private var notes: List<NoteItem>, private val itemClickListener: OnItemClickListner):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    //lecture 73 Deletion and updation of data from firebase realtime database
    interface OnItemClickListner{
        fun onDeleteClick(noteId: String)
//        fun onUpdateClick(noteId: String)
        fun onUpdateClick(noteId: String, title: String, description: String) {



        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding:NotesitemBinding=NotesitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note:NoteItem=notes[position]
        holder.bind(note)

        //lecture 73
        holder.binding.deleteButton.setOnClickListener {
//            itemClickListener.onDeleteClick(note.noteId!!)
            note.noteId ?. let { it1 -> itemClickListener.onDeleteClick(it1) }

//            try {
//                // Call onDeleteClick and pass the noteId
//                note.noteId?.let { it1 -> itemClickListener.onDeleteClick(it1) }
//            } catch (e: Exception) {
//                // Handle the exception here
//                Log.e("NoteAdapter", "Exception during onDeleteClick: ${e.message}", e)
//            }

        }

        holder.binding.updateButton.setOnClickListener {
//            (note.noteId,note.title,note.description)?.let { it-> itemClickListener.onUpdateClick(it) }
            itemClickListener.onUpdateClick(note.noteId !!,note.title !!,note.description !!)
        }
    }
    override fun getItemCount(): Int {
        return notes.size
    }
    fun updateData(newNotes: List<NoteItem>) {
        notes = newNotes
        notifyDataSetChanged()
    }

    class NoteViewHolder(val binding:NotesitemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteItem) {
            binding.titleTextView.text=note.title
            binding.descriptionTextView.text=note.description
        }

    }
}

//private fun OnItemClickListener.onUpdateClick(noteId: String?) {
//}

//private fun OnItemClickListener.onDeleteClick(noteId: String?) {
//
//}
