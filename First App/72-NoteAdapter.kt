package com.example.sampleapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sampleapp.databinding.NotesitemBinding

class NoteAdapter(private var notes: List<NoteItem>):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding:NotesitemBinding=NotesitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note:NoteItem=notes[position]
        holder.bind(note)
    }
    override fun getItemCount(): Int {
        return notes.size
    }
    fun updateData(newNotes: List<NoteItem>) {
        notes = newNotes
        notifyDataSetChanged()
    }

    class NoteViewHolder(private val binding:NotesitemBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteItem) {
            binding.titleTextView.text=note.title
            binding.descriptionTextView.text=note.description
        }

    }
}
