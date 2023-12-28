package com.example.demo

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.databinding.RvItemBinding

class RvAdapter(var context: Context,var list: ArrayList<user>):
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    class ViewHolder(var binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return  ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.updateUsername.text=list.get(position).name
        holder.binding.updatePassword.text=list.get(position).pass
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
