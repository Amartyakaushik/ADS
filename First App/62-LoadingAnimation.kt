package com.example.sampleapp

//import android.R
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.github.ybq.android.spinkit.sprite.Sprite
import com.github.ybq.android.spinkit.style.DoubleBounce
import com.github.ybq.android.spinkit.style.FoldingCube
import com.github.ybq.android.spinkit.style.WanderingCubes
import com.github.ybq.android.spinkit.style.Wave


class LoadingAnimation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_animation)

        //Wave
        val progressBar = findViewById<View>(R.id.spin_kit02) as ProgressBar
        val wave01: Sprite= Wave()
        progressBar.indeterminateDrawable = wave01

        // Wandering Cubes
        val progressBar02=findViewById<View>(R.id.spin_kit03) as ProgressBar
        val wanderingCubes: Sprite= WanderingCubes()
        progressBar02.indeterminateDrawable=wanderingCubes

        //FoldingCube
        val progressBar03=findViewById<View>(R.id.spin_kit04) as ProgressBar
        val foldingCube: Sprite= FoldingCube()
        progressBar03.indeterminateDrawable=foldingCube

    }
}
