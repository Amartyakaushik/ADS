package com.example.demo

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.demo.databinding.RvItemBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class RvAdapter(var context: Context,var list: ArrayList<user>):
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    class ViewHolder(var binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(note: user){
//            binding.updateUsername.text=note.name
//            binding.updatePassword.text=note.pass
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding=RvItemBinding.inflate(LayoutInflater.from(context),parent,false)
        return  ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val note:user=list[position]
//        holder.bind(note)
        holder.binding.username.text=list[position].name
        holder.binding.password.text=list[position].pass

//        val currentUser=list[position]
//        holder.binding.updateUsername.text=currentUser.name
//        holder.binding.updatePassword.text=currentUser.pass

//        LECTURE 83
//        Now to delete data from the Firestore database
        holder.binding.deleteBtn.setOnClickListener{
            val db= Firebase.firestore
            db.collection("Users")
                .document(list.get(position).id!!)
                .delete()
                .addOnSuccessListener {
                    list.removeAt(position)
                    notifyDataSetChanged()
                    Log.d("TAG", "Data deleted: ")
                }
                .addOnFailureListener {e->
                    Log.e("failed", "Failde to delete data: ",e )
                }
        }



//       LECTURE 84
        holder.binding.updateBtn.setOnClickListener{
//            context.startActivity(Intent(context,updatePage::class.java).putExtra())
            val intent=Intent(context,updatePage::class.java)
            intent.putExtra("NAME",list.get(position).name)
            intent.putExtra("PASS",list.get(position).pass)
            intent.putExtra("ID",list.get(position).id)
            context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {

        return list.size
    }

}
