package com.tvacstudio.motionlayout

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_scrolling.*
import kotlinx.android.synthetic.main.motion_17_coordination_header.*

class MainActivity : AppCompatActivity(), StickyScrollView.OnScrollChangedListener {

    private var deltaY: Int = 0
    var alpha = 1.0f
    var newAlpha = 1.0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.motion_17_coordination)

        // used by TextView
        description.text = resources.getString(R.string.large_text)
        Utils.makeTextViewResizable(description, 4, "See More", true)
        scrollable.setOnScrollChangedListener(this)
    }

    private fun fadeOut(view: View) {
        Log.i("ViewNameFadeOut", "Name: $view")
        if (view.visibility != View.GONE) {
            view.alpha = 0.5f
            view.animate()
                .alpha(0f)
                .setListener(object : AnimatorListenerAdapter() {
                    var cancel = false
                    override fun onAnimationCancel(animation: Animator?) {
                        super.onAnimationCancel(animation)
                        cancel = true
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        if (!cancel)
                            view.visibility = View.GONE
                    }
                })
        }
    }

    private fun fadeOutHeader(view: View) {
        Log.i("ViewNameFadeOut", "Name: $view")
        view.alpha = 0.5f
        view.animate().alpha(0f).duration = 200;
    }

    private fun fadeIn(view: View) {
        Log.i("ViewNameFadeIn", "Name: $view")
        if (view.visibility == View.GONE) {
            view.alpha = 0.5f
            view.animate()
                .alpha(1f)
                .setDuration(1)
                .setListener(object : AnimatorListenerAdapter() {
                    var cancel = false
                    override fun onAnimationCancel(animation: Animator?) {
                        super.onAnimationCancel(animation)
                        cancel = true
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        if (!cancel)
                            view.visibility = View.VISIBLE
                    }
                })
        }
    }

    private fun fadeInHeader(view: View) {
        Log.i("ViewNameFadeIn", "Name: $view")
        if (view.visibility == View.GONE) {
            view.alpha = 0.5f
            view.animate()
                .alpha(1f)
                .setDuration(200)
                .setListener(object : AnimatorListenerAdapter() {
                    var cancel = false
                    override fun onAnimationCancel(animation: Animator?) {
                        super.onAnimationCancel(animation)
                        cancel = true
                    }

                    override fun onAnimationEnd(animation: Animator) {
                        if (!cancel) {
                            view.visibility = View.VISIBLE
                        }
                    }
                })
        }
    }

    override fun onScrollChanged(scrollX: Int, scrollY: Int, oldscrollX: Int, oldScrollY: Int) {
        label.text = detail_dollar_amount.text
        sublabel.text = detail_item_name.text
        deltaY = oldScrollY + (scrollY - oldScrollY)

        //if scroll left

        //if scroll left

        if (scrollY < oldScrollY) {
            newAlpha = alpha - 0.1f
            if (newAlpha >= 0) {
                label.alpha = newAlpha - 0.1f
                sublabel.alpha = newAlpha - 0.1f
                alpha = newAlpha
            }
        }

        //if scroll right

        if (scrollY > oldScrollY) {
            newAlpha = alpha + 0.1f
            if (newAlpha <= 1) {
                label.alpha = newAlpha + 0.1f
                sublabel.alpha = newAlpha + 0.1f
                alpha = newAlpha
            }
        }
//        if (scrollY > oldScrollY) {
//            //swipeDown
////            fadeOutHeader(label)
////            fadeOutHeader(sublabel)
//        }
//        if (scrollY < oldScrollY) {
//            //swipeUp
//            fadeInHeader(label)
//            fadeInHeader(sublabel)
//        }
//        if (scrollY == 0) {
//            //Top
//            fadeOutHeader(label)
//            fadeOutHeader(sublabel)
//        }
//        if (scrollY == (scrollable.measuredHeight - scrollable.getChildAt(0).measuredHeight)) {
//            //Bottom
////            fadeInHeader(label)
////            fadeInHeader(sublabel)
//        }


    }
}
