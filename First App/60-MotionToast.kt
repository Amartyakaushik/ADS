@file:Suppress("UNUSED_PARAMETER")

package com.example.sampleapp

import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.example.sampleapp.databinding.ActivityFragmentsBinding
import com.example.sampleapp.databinding.ActivityMotionToastBinding
import www.sanju.motiontoast.MotionToast.Companion.createColorToast
import www.sanju.motiontoast.MotionToastStyle
import www.sanju.motiontoast.R

class MotionToast : AppCompatActivity() {
    private lateinit var binding:ActivityMotionToastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMotionToastBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener {
            MotionToast.createToast(this,"Delete all history!",
                MotionToastStyle.DELETE,
                www.sanju.motiontoast.MotionToast.GRAVITY_BOTTOM,
                www.sanju.motiontoast.MotionToast.LONG_DURATION,
//                MotionToast.GRAVITY_BOTTOM,
//                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(this,R.font.helvetica_regular))

        }

//        binding.buttontoast.setOnClickListener {
//            createColorToast(this,"Hurray sucessful","Upload comleted sucessfully",
//                MotionToastStyle.SUCCESS,
//                MotionToast.GRAVITYBOTTOM,
//                MotionToast.LONGDURATION,
//                ResourcesCompat.getFont(this, R.font.helvetica_regular))

//            MotionToast.darkToast(this,"Please fill all the details!",
//                MotionToastStyle.WARNING,
//                GRAVITY_BOTTOM,
//                MotionToast.LONG_DURATION,
//                ResourcesCompat.getFont(this,R.font.helvetica_regular))


//            MotionToast.createToast(this,"This is information toast!",
//                MotionToastStyle.INFO,
//                MotionToast.GRAVITY_BOTTOM,
//                MotionToast.LONG_DURATION,
//                ResourcesCompat.getFont(this,R.font.helvetica_regular))


//            MotionToast.createToast(this,"Delete all history!",
//                MotionToastStyle.DELETE,
//                MotionToast.GRAVITY_BOTTOM,
//                MotionToast.LONG_DURATION,
//                ResourcesCompat.getFont(this,R.font.helvetica_regular))



//        }



    }

//    companion object {
//        fun darkToast(
//            motionToast: MotionToast,
//            s: String,
//            warning: MotionToastStyle,
//            gravityBottom: Any,
//            longDuration: Any,
//            font: Typeface?
//        ) {
//            TODO("Not yet implemented")
//        }
//
//        val LONG_DURATION:
//        val GRAVITY_BOTTOM:
//    }

//    companion object {
//    fun createToast(
//        motionToast: MotionToast,
//        s: String,
//        delete: MotionToastStyle,
//        gravityBottom: Any,
//        longDuration: Any,
//        font: Typeface?
//    ) {
//        TODO("Not yet implemented")
//    }
//
//    val GRAVITY_BOTTOM: Any
//        get() {
//            TODO()
//        }
//    val LONG_DURATION: Any
//        get() = TODO()
//}
    companion object {
    fun createToast(
        motionToast: MotionToast,
        s: String,
        delete: MotionToastStyle,
        gravityBottom: Int,
        longDuration: Long,
        font: Typeface?)
    {
        TODO("Let's do it")
    }
}

}
