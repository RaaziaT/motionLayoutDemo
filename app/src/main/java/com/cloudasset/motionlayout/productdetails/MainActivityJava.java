package com.cloudasset.motionlayout.productdetails;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudasset.motionlayout.R;
import com.cloudasset.motionlayout.utils.StickyScrollView;

import java.util.ArrayList;
import java.util.Collections;

import me.relex.circleindicator.CircleIndicator;

public class MainActivityJava extends AppCompatActivity implements StickyScrollView.OnScrollChangedListener {

    float alpha = 1.0f;
    float newAlpha = 1.0f;
    private int totalUpperHeight = 0;
    private View header;
    private View content;
    private TextView textViewHeaderName, textViewHeaderPrice, textViewDescription, textViewName, textViewPrice;
    private LinearLayout quantity;
    private MotionLayout detail;
    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private static final Integer[] IMAGES = new Integer[]{R.drawable.himalayas, R.drawable.monterey, R.drawable.sea, R.drawable.roard};
    private ArrayList<Integer> ImagesArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_description);
        initViews();

        textViewHeaderPrice.setText(textViewPrice.getText().toString());
        textViewHeaderName.setText(textViewName.getText().toString());
        // used by TextView
        textViewDescription.setText(getResources().getString(R.string.large_text));
//        textViewDescription.setText("getResources().getString(R.string.large_text)");

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int height = dm.heightPixels;
        quantity.measure(0, 0);
        int heightOfQuantity = quantity.getMeasuredHeight();
        textViewPrice.measure(0, 0);
        int heightOfAmount = textViewPrice.getMeasuredHeight();
        textViewName.measure(0, 0);
        int heightOfName = textViewName.getMeasuredHeight();
        header.measure(0, 0);
        int heightOfHeader = textViewName.getMeasuredHeight();
        textViewDescription.measure(0, 0);
        int heightOfDescription = textViewDescription.getMeasuredHeight();

        totalUpperHeight = heightOfHeader + heightOfQuantity + heightOfAmount + heightOfName;
        int remainingHeight = height - totalUpperHeight - heightOfDescription;

        if ((remainingHeight) >= 0) {
            ((MotionLayout) header).setTransition(R.id.start, R.id.start);
            detail.setTransition(R.id.start, R.id.start);
        } else {
            ((MotionLayout) header).setTransition(R.id.start, R.id.end);
            detail.setTransition(R.id.start, R.id.end);
        }

        ((StickyScrollView) content).setOnScrollChangedListener(this);

    }


    private void initViews() {
        header = findViewById(R.id.motionLayout);
        content = findViewById(R.id.scrollable);
        textViewHeaderPrice = header.findViewById(R.id.label);
        textViewHeaderName = header.findViewById(R.id.sublabel);
        viewPager = header.findViewById(R.id.background);
        circleIndicator = header.findViewById(R.id.detail_indicator);
        textViewName = content.findViewById(R.id.detail_item_name);
        textViewPrice = content.findViewById(R.id.detail_dollar_amount);
        textViewDescription = content.findViewById(R.id.description);
        quantity = content.findViewById(R.id.detail_quantity_ll);
        detail = findViewById(R.id.descriptionLayout);
        Collections.addAll(ImagesArray, IMAGES);
        viewPager.setAdapter(new SlidingImageAdapter(this, ImagesArray));
        circleIndicator.setViewPager(viewPager);
    }

    @Override
    public void onScrollChanged(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        if (scrollY > oldScrollY) {
            newAlpha = alpha + 0.1f;
            if (newAlpha <= 1) {
                textViewHeaderPrice.setAlpha(newAlpha + 0.1f);
                textViewHeaderName.setAlpha(newAlpha + 0.1f);
                alpha = newAlpha;
            }
        }
    }
}