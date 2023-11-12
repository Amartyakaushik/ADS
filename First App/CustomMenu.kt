package com.example.sampleapp

import android.content.Context
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast

class CustomMenu {
    fun customeMenu(context:Context,view:View){
        val pop=PopupMenu(context,view)
        pop.inflate(R.menu.menu_rsc)

        pop.setOnMenuItemClickListener {
            when(it!!.itemId){
                R.id.edit->{
                    Toast.makeText(context, "clicked edited", Toast.LENGTH_LONG).show()
                    true
                }

                R.id.delete->{
                    Toast.makeText(context, "clicked deleted", Toast.LENGTH_LONG).show()
                    true
                }

                R.id.share->{
                    Toast.makeText(context, "clicked shared", Toast.LENGTH_LONG).show()
                    true
                }

                else->false
            }
        }

        try {
            val fieldMpopup=PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMpopup.isAccessible=true
            val mPopup=fieldMpopup.get(pop)
            mPopup.javaClass
                .getDeclaredMethod("setForceShowIcon",Boolean::class.java)
                .invoke(mPopup,true)
        }catch (e:Exception){
        }finally {
            pop.show()
        }


    }
}