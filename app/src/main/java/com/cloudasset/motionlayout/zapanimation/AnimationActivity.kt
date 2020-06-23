package com.cloudasset.motionlayout.zapanimation

import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.view.animation.*
import android.view.animation.Animation.AnimationListener
import android.view.animation.Animation.INFINITE
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.cloudasset.motionlayout.R
import kotlinx.android.synthetic.main.activity_animation.*


class AnimationActivity : AppCompatActivity() {
    var imagesToShow =
        intArrayOf(
            R.drawable.zapp_man_off,
            R.drawable.zapp_man_on
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

//        translationAnimation(imageView_zapp_man_off)
        btn_showDialog.setOnClickListener { showDialog() }

    }

    private fun translationAnimation(
        imageView: ImageView,
        imageViewBackground: ImageView) {
        val animZoomIn = AnimationUtils.loadAnimation(this,
            R.anim.zoom_in
        )
        imageViewBackground.startAnimation(animZoomIn)
//        animZoomIn.setAnimationListener(object : AnimationListener {
//            override fun onAnimationEnd(animation: Animation) {
//                if (animation == animZoomIn) {
//
//                }
//            }
//
//            override fun onAnimationRepeat(animation: Animation) {
//                // TODO Auto-generated method stub
//            }
//
//            override fun onAnimationStart(animation: Animation) {
//                // TODO Auto-generated method stub
//            }
//        })
        val tanimation = TranslateAnimation(
            0.0f,
            360.0f,
            0.0f,
            0.0f
        ) //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        tanimation.duration = 1000 // animation duration
        tanimation.repeatCount = INFINITE // animation repeat count
        tanimation.repeatMode = 2


        Handler().postDelayed({
            imageView.setImageDrawable(resources.getDrawable(R.drawable.zapp_man_on))
            Handler().postDelayed({
                imageView.startAnimation(tanimation)
//                motionLayout.setTransition(R.id.start, R.id.end)
            }, 1000)
        }, 1000)


    }


    private fun animate(
        imageView: ImageView,
        images: IntArray,
        imageIndex: Int,
        forever: Boolean
    ) {

        //imageView <-- The View which displays the images
        //images[] <-- Holds R references to the images to display
        //imageIndex <-- index of the first image to show in images[]
        //forever <-- If equals true then after the last image it starts all over again with the first image resulting in an infinite loop. You have been warned.
        val fadeInDuration = 1 // Configure time values here
        val timeBetween = 500
        val fadeOutDuration = 1

        imageView.visibility =
            View.INVISIBLE //Visible or invisible by default - this will apply when the animation ends
        imageView.setImageResource(images[imageIndex])

        val fadeIn: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
        fadeIn.interpolator = DecelerateInterpolator() // add this
        fadeIn.duration = fadeInDuration.toLong()

        val fadeOut: Animation = AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
        fadeOut.interpolator = AccelerateInterpolator() // and this
        fadeOut.startOffset = fadeInDuration + timeBetween.toLong()
        fadeOut.duration = fadeOutDuration.toLong()

        // repeat animation (left to right, right to left )


        val animation = AnimationSet(false) // change to false
//        animation.addAnimation(tanimation)
        animation.addAnimation(fadeIn)
        animation.addAnimation(fadeOut)
        animation.repeatCount = 1
        imageView.animation = animation


        animation.setAnimationListener(object : AnimationListener {
            override fun onAnimationEnd(animation: Animation) {
                if (images.size - 1 > imageIndex) {
                    animate(
                        imageView,
                        images,
                        imageIndex + 1,
                        forever
                    )
//                    imageView.animation = tanimation//Calls itself until it gets to the end of the array
                } else {
                    if (forever) {
                        animate(
                            imageView,
                            images,
                            0,
                            forever
                        ) //Calls itself to start the animation all over again in a loop if forever = true
//                        imageView.animation = tanimation//Calls itself until it gets to the end of the array
                    }
                }
            }

            override fun onAnimationRepeat(animation: Animation) {
                // TODO Auto-generated method stub
            }

            override fun onAnimationStart(animation: Animation) {
                // TODO Auto-generated method stub
            }
        })
    }

    private fun showDialog() {
        val builder = AlertDialog.Builder(this)
        val dialog: AlertDialog
        val view = LayoutInflater.from(this).inflate(R.layout.dialog_animation, null)
        val imageView: ImageView = view.findViewById(R.id.imageView_zapp_man_off)
        val imageViewBackground: ImageView = view.findViewById(R.id.background)
        val close: ImageView = view.findViewById(R.id.close_btn)
        translationAnimation(imageView, imageViewBackground)
        builder.setView(view)
        dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawable(resources.getDrawable(R.drawable.dialog_background_black))
        dialog.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
        dialog.window?.setGravity(Gravity.CENTER)
        dialog.setCancelable(false)
        close.setOnClickListener { dialog.dismiss() }
    }
}