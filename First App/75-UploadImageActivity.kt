package com.example.sampleapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sampleapp.databinding.ActivityPhotoUploadBinding
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import com.squareup.picasso.Picasso

class PhotoUploadActivity : AppCompatActivity() {
    lateinit var binding:ActivityPhotoUploadBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPhotoUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.uploadImageButton.setOnClickListener {
            val intent=Intent()
            intent.action=Intent.ACTION_PICK
            intent.type="image/*"
            imageLauncher.launch(intent)

        }
    }

    // Decalration of imageLaucher
//    val imageLauncher=registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
//        if(it.resultCode== Activity.RESULT_OK){
//            if (it.data!=null){
//                val ref=Firebase.storage.reference.child("photo")
//                ref.putFile(it.data!!.data!!).addOnSuccessListener {
//                    ref.downloadUrl.addOnSuccessListener {
////                        binding.myImageView.setImageURI(it)
//                        Toast.makeText(this@PhotoUploadActivity,"Photo Uploaded",Toast.LENGTH_LONG).show()
//                        Picasso.get().load(it.toString()).into(binding.myImageView);
//                    }
//                }
//            }
//        }
//    }

    val imageLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { imageUri ->
                // Check if the selected data is an image
                if (imageUri.toString().startsWith("content://") || imageUri.toString()
                        .startsWith("file://")
                ) {
                    val ref = Firebase.storage.reference.child("photo")
                    ref.putFile(imageUri).addOnSuccessListener { taskSnapshot ->
                        ref.downloadUrl.addOnSuccessListener { downloadUri ->
                            // Use Picasso to load the image into ImageView
                            Picasso.get().load(downloadUri.toString()).into(binding.myImageView)
                            Toast.makeText(
                                this@PhotoUploadActivity,
                                "Photo Uploaded",
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }.addOnFailureListener {
                        Toast.makeText(
                            this@PhotoUploadActivity,
                            "Failed to upload photo",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@PhotoUploadActivity,
                        "Selected file is not an image",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }

    }


}
