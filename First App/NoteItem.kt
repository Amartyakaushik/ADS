package com.example.sampleapp

data class NoteItem(val title:String?,val description:String?,val noteId:String?){
    constructor():this(null,null,null)
}
