package com.cloudasset.motionlayout.walkthrough.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudasset.motionlayout.R;
import com.cloudasset.motionlayout.walkthrough.WalkThroughActivity;

public class InstanceUpdateFragment extends Fragment {

    private ImageView imageView, imageViewBolt, imageViewNotification;
    private TextView textView;
    private Animation slideUp, slideDown, slideLeft;
    private int count = 1;
    private Animation slideDownLess;

    public InstanceUpdateFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static InstanceUpdateFragment newInstance() {
        return new InstanceUpdateFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instance_update, container, false);
        imageView = view.findViewById(R.id.image);
        imageViewBolt = view.findViewById(R.id.image_bolt);
        imageViewNotification = view.findViewById(R.id.image_notification);
        textView = view.findViewById(R.id.txtView_back);
        slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        slideDownLess = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down_less);
        slideLeft = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
//        imageView.setVisibility(View.GONE);
//        imageViewBolt.setVisibility(View.GONE);
//        imageViewNotification.setVisibility(View.GONE);
//        textView.setVisibility(View.GONE);

//        imageView.startAnimation(slideLeft);
//        imageViewNotification.startAnimation(slideUp);
//        imageViewBolt.startAnimation(slideDown);
//        textView.startAnimation(slideDown);
        return view;
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && count == 1) {
            imageView.setVisibility(View.VISIBLE);
            imageViewBolt.setVisibility(View.VISIBLE);
            imageViewNotification.setVisibility(View.VISIBLE);
            textView.setVisibility(View.VISIBLE);
            imageView.startAnimation(slideLeft);
            imageViewNotification.startAnimation(slideUp);
            imageViewBolt.startAnimation(slideDownLess);
            textView.startAnimation(slideDown);
            count--;
        } else {
        }
        if (isVisibleToUser){
            ((WalkThroughActivity) getActivity()).changeDetails("InstanceUpdateFragment","InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}