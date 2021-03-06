package com.cloudasset.motionlayout.productdetails

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.cloudasset.motionlayout.R
import com.cloudasset.motionlayout.utils.StickyScrollView
import kotlinx.android.synthetic.main.product_description.*
import kotlinx.android.synthetic.main.product_description_detail.*
import kotlinx.android.synthetic.main.product_description_header.*


class MainActivity : AppCompatActivity(),
    StickyScrollView.OnScrollChangedListener {

    var alpha = 1.0f
    var newAlpha = 1.0f

    var totalUpperHeight = 0
    var screenHeight = 0

    var IMAGES =
        arrayOf<Int>(
            R.drawable.himalayas,
            R.drawable.monterey,
            R.drawable.sea,
            R.drawable.roard
        )
    private val ImagesArray = ArrayList<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_description)

        label.text = detail_dollar_amount.text
        sublabel.text = detail_item_name.text
        description.text = resources.getText(R.string.large_text)
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        val height = dm.heightPixels
        detail_quantity_ll.measure(0, 0)
        val heightOfQuantity = detail_quantity_ll.measuredHeight
        detail_dollar_amount.measure(0, 0)
        val heightOfAmount = detail_dollar_amount.measuredHeight
        detail_item_name.measure(0, 0)
        val heightOfName = detail_item_name.measuredHeight
        motionLayout.measure(0, 0)
        val heightOfMotionLayout = motionLayout.measuredHeight
        description.measure(0, 0)
        val heightOfDescription = description.measuredHeight

        totalUpperHeight = heightOfMotionLayout + heightOfQuantity + heightOfAmount + heightOfName

        val remainingHeight = height - totalUpperHeight - heightOfDescription


        if ((remainingHeight) >= 0) {
            motionLayout.setTransition(
                R.id.start,
                R.id.start
            )
            descriptionLayout.setTransition(
                R.id.start,
                R.id.start
            )
        } else {
            motionLayout.setTransition(
                R.id.start,
                R.id.end
            )
            descriptionLayout.setTransition(
                R.id.start,
                R.id.end
            )
        }

        scrollable.setOnScrollChangedListener(this)
        init()


    }

    private fun init() {
        for (i in IMAGES.indices) ImagesArray.add(IMAGES[i])
        background.adapter =
            SlidingImageAdapter(
                this,
                ImagesArray
            )
        detail_indicator.setViewPager(background)
    }
    private fun fadeOut(view: View) {
        Log.i("ViewNameFadeOut", "Name: $view")
        if (view.visibility != View.GONE) {
            view.alpha = 0.5f
            view.animate()
                .alpha(0f)
                .setDuration(200)
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
        //if scroll top
        if (scrollY > oldScrollY) {
            newAlpha = alpha + 0.1f
            if (newAlpha <= 1) {
                label.alpha = newAlpha + 0.1f
                sublabel.alpha = newAlpha + 0.1f
                alpha = newAlpha
            }
        }
    }
}
