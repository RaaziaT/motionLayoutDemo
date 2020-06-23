package com.cloudasset.motionlayout.walkthrough.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cloudasset.motionlayout.R;
import com.cloudasset.motionlayout.walkthrough.WalkThroughActivity;

public class TrackingFragment extends Fragment {

    private ImageView imageView, imageViewLocation, imageViewMap;
    private Animation slideUp, slideDown, slideLeft;
    private int count = 1;

    public TrackingFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static TrackingFragment newInstance() {
        return new TrackingFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tracking, container, false);
        imageView = view.findViewById(R.id.image);
        imageViewLocation = view.findViewById(R.id.image_location);
        imageViewMap = view.findViewById(R.id.image_map);
        slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down_less);
        slideLeft = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
//        imageView.setVisibility(View.GONE);
//        imageViewMap.setVisibility(View.GONE);
//        imageViewLocation.setVisibility(View.GONE);


        return view;
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && count == 1) {
            imageView.setVisibility(View.VISIBLE);
            imageViewMap.setVisibility(View.VISIBLE);
            imageViewLocation.setVisibility(View.VISIBLE);
            imageView.startAnimation(slideLeft);
            imageViewMap.startAnimation(slideUp);
            imageViewLocation.startAnimation(slideDown);
            count--;
        } else {
        }

        if (isVisibleToUser) {
            ((WalkThroughActivity) getActivity()).changeDetails("TrackingFragment", "InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}