package com.cloudasset.motionlayout

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.animation.*
import android.view.animation.Animation.AnimationListener
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animation.*


class AnimationActivity : AppCompatActivity() {
//    private var shortAnimationDuration: Int = 0

    var imagesToShow =
        intArrayOf(R.drawable.zapp_man_off, R.drawable.zapp_man_on)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        // Retrieve and cache the system's default "short" animation time.
//        shortAnimationDuration = resources.getInteger(android.R.integer.config_shortAnimTime)
//
//        val myFadeInAnimation: Animation =
//            AnimationUtils.loadAnimation(this, android.R.anim.fade_in)
//        val myFadeOutAnimation: Animation =
//            AnimationUtils.loadAnimation(this, android.R.anim.fade_out)
//
//        imageView_zapp_man_on.startAnimation(myFadeInAnimation)
//        imageView_zapp_man_off.startAnimation(myFadeOutAnimation)
//        imageView_zapp_man_on.startAnimation(myFadeOutAnimation)
//        imageView_zapp_man_off.startAnimation(myFadeInAnimation)

//        if (switcher.displayedChild == 0) {
//            switcher.showNext()
//        } else {
//            switcher.showPrevious()
//        }
        animate(imageView_zapp_man_off, imagesToShow, 0, true)
    }

//    private fun crossfade() {
//        imageView_zapp_man_off.apply {
//            // Set the content view to 0% opacity but visible, so that it is visible
//            // (but fully transparent) during the animation.
//            alpha = 0f
//            visibility = View.VISIBLE
//
//            // Animate the content view to 100% opacity, and clear any animation
//            // listener set on the view.
//            animate()
//                .alpha(1f)
//                .setDuration(shortAnimationDuration.toLong())
//                .setListener(null)
//        }
//        // Animate the loading view to 0% opacity. After the animation ends,
//        // set its visibility to GONE as an optimization step (it won't
//        // participate in layout passes, etc.)
//        imageView_zapp_man_on.animate()
//            .alpha(0f)
//            .setDuration(shortAnimationDuration.toLong())
//            .setListener(object : AnimatorListenerAdapter() {
//                override fun onAnimationEnd(animation: Animator) {
//                    imageView_zapp_man_on.visibility = View.GONE
//                }
//            })
//    }


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
        val timeBetween = 300
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


        val animation = AnimationSet(false) // change to false
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
                    ) //Calls itself until it gets to the end of the array
                } else {
                    if (forever) {
                        animate(
                            imageView,
                            images,
                            0,
                            forever
                        ) //Calls itself to start the animation all over again in a loop if forever = true
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
}