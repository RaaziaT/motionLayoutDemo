package com.cloudasset.motionlayout.walkthrough;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cloudasset.motionlayout.R;
import com.cloudasset.motionlayout.walkthrough.fragments.InstanceUpdateFragment;
import com.cloudasset.motionlayout.walkthrough.fragments.SmartSearchFragment;
import com.cloudasset.motionlayout.walkthrough.fragments.StoreAndIndustryFragment;
import com.cloudasset.motionlayout.walkthrough.fragments.TrackingFragment;
import com.cloudasset.motionlayout.walkthrough.fragments.ZappWalletFragment;

import org.jetbrains.annotations.NotNull;

import me.relex.circleindicator.CircleIndicator;

public class WalkThroughActivity extends AppCompatActivity {
    private LinearLayout linearLayout;
    private Animation slideUpBottom;
    private ViewPager viewPager;
    private TextView title, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walk_through);
        viewPager = findViewById(R.id.viewPager);

        CircleIndicator circleIndicator = findViewById(R.id.detail_indicator);
        linearLayout = findViewById(R.id.linearLayout);
        slideUpBottom = AnimationUtils.loadAnimation(this, R.anim.slide_up_bottom);
        title = findViewById(R.id.txtView_title);
        description = findViewById(R.id.txtView_description);
        linearLayout.setVisibility(View.GONE);
        setupView();
        circleIndicator.setViewPager(viewPager);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                linearLayout.setVisibility(View.VISIBLE);
                linearLayout.startAnimation(slideUpBottom);
            }
        }, 1000);
    }


    public void setupView() {
        /*
         * The pager adapter, which provides the pages to the view pager widget.
         */
        PagerAdapter mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mPagerAdapter);
        viewPager.setCurrentItem(0);

    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @NotNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return ZappWalletFragment.newInstance();
                case 1:
                    return StoreAndIndustryFragment.newInstance();
                case 2:
                    return TrackingFragment.newInstance();
                case 3:
                    return SmartSearchFragment.newInstance();
                case 4:
                    return InstanceUpdateFragment.newInstance();
                default:
                    return null;

            }
        }

        @Override
        public int getCount() {
            return 5;
        }


    }

    public void changeDetails(String title, String description) {
        this.title.setText(title);
        this.description.setText(description);
    }
}