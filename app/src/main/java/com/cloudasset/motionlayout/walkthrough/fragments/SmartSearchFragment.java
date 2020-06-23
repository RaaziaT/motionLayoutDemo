package com.cloudasset.motionlayout.walkthrough.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

public class SmartSearchFragment extends Fragment {

    private ImageView imageView, imageViewInput, imageViewElement;
    private Animation slideUp, slideDown, slideLeft;
    private int count = 1;

    public SmartSearchFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SmartSearchFragment newInstance() {
        return new SmartSearchFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_smart_search, container, false);
        imageView = view.findViewById(R.id.image);
        imageViewInput = view.findViewById(R.id.image_input);
        imageViewElement = view.findViewById(R.id.image_element);
        slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down_less);
        slideLeft = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
        imageView.setVisibility(View.GONE);
        imageViewElement.setVisibility(View.GONE);
        imageViewInput.setVisibility(View.GONE);

//        imageView.startAnimation(slideLeft);
//        imageViewElement.startAnimation(slideDown);
//        imageViewInput.startAnimation(slideUp);

        return view;
    }

    @Override
    public void onAttachFragment(@NonNull Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && count ==1) {
            imageView.setVisibility(View.VISIBLE);
            imageViewElement.setVisibility(View.VISIBLE);
            imageViewInput.setVisibility(View.VISIBLE);
            imageView.startAnimation(slideLeft);
            imageViewElement.startAnimation(slideDown);
            imageViewInput.startAnimation(slideUp);
            count --;
        } else {
        }
        if (isVisibleToUser){
            ((WalkThroughActivity) getActivity()).changeDetails("SmartSearchFragment","InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment");
        }
    }


}