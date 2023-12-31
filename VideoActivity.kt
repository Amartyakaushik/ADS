package com.example.sampleapp

import android.app.Activity
import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.MimeTypeMap
import android.widget.MediaController
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.swiperefreshlayout.widget.CircularProgressDrawable.ProgressDrawableSize
import com.example.sampleapp.databinding.ActivityVideoBinding
import com.google.firebase.Firebase
import com.google.firebase.database.database
import com.google.firebase.storage.storage

class VideoActivity : AppCompatActivity() {
    private lateinit var binding:ActivityVideoBinding
//    Lecture 79
    private lateinit var progressDialog:ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityVideoBinding.inflate(layoutInflater)
        //    Lecture 79
        progressDialog=ProgressDialog(this)
        setContentView(binding.root)

        binding.videoView02.isVisible = false
        binding.videoBtn02.setOnClickListener {
            val intent = Intent()
            intent.action=Intent.ACTION_PICK
            intent.type="Video/*"
            videoLauncher.launch(intent)
        }
    }
//    val videoLauncher=registerForActivityResult
    val videoLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            if(it.data != null && it.data!!.data != null){
//                lecture 79
                progressDialog.setTitle("Uploading...")
                progressDialog.show()
                val ref= Firebase.storage.reference.child("Video/"+System.currentTimeMillis()+"."+getFileType(it.data!!.data))
                ref.putFile(it.data!!.data!!).addOnSuccessListener{
                    ref.downloadUrl.addOnSuccessListener { it1 ->
                        Firebase.database.reference.child("Video").push().setValue(it1.toString())

//                        lecture 79
                        progressDialog.dismiss()

                        Toast.makeText(this@VideoActivity,"Video Uploaded",Toast.LENGTH_LONG).show()
                        binding.videoBtn02.isVisible = false
                        binding.videoView02.isVisible = true
                        val mediaController = MediaController(this)
                        mediaController.setAnchorView(binding.videoView02)

                        binding.videoView02.setVideoURI(it1)
                        binding.videoView02.setMediaController(mediaController)
                        binding.videoView02.start()
//                        lecture 79
                        binding.videoView02.setOnCompletionListener {
                            ref.delete().addOnSuccessListener {
                                Toast.makeText(this@VideoActivity,"Video Deleted",Toast.LENGTH_LONG).show()
                            }
                        }
                    }
                }

//                    lecture 79
                    .addOnProgressListener {
                        val value=(it.bytesTransferred/it.totalByteCount)*100
                        progressDialog.setTitle("Uploaded"+value.toString()+"%")
                    }

//                Exception handling
                    .addOnFailureListener { e ->
                        Toast.makeText(this@VideoActivity, "Failed to upload video: ${e.message}", Toast.LENGTH_LONG).show()
                        Log.e("VideoActivity","Failed to upload video",e)
//                        Log.e("VideoActivity", "Failed to upload video", e)
                    }
            }else {
                // Handle the case where data is null
                Toast.makeText(this, "Failed to get video data", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getFileType(data: Uri?): String? {
        val mimeType= MimeTypeMap.getSingleton()
        return mimeType.getMimeTypeFromExtension(contentResolver.getType(data!!))
    }


}