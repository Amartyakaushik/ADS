package com.example.lpuliveclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lpuliveclone.R
import com.example.lpuliveclone.RvModel
import com.example.lpuliveclone.databinding.ItemViewBinding

class RvAdapter(var datalist: ArrayList<RvModel>, var context: Context):RecyclerView.Adapter<RvAdapter.MyViewHolder>() {

    inner class MyViewHolder(var binding: ItemViewBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
//        return MyViewHolder(view)
        var binding=ItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.binding.profile.setImageResource(datalist.get(position).profile)
        holder.binding.identification.text=datalist.get(position).Identification
        holder.binding.recentMessage.text=datalist.get(position).recent_message
        holder.binding.lastDuration.text=datalist.get(position).last_duration
    }
}