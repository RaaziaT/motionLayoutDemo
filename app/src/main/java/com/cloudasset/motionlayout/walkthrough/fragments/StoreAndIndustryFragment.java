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
import android.widget.TextView;

import com.cloudasset.motionlayout.R;
import com.cloudasset.motionlayout.walkthrough.WalkThroughActivity;

public class StoreAndIndustryFragment extends Fragment {

    private ImageView imageView, imageViewPhone, imageViewWallet;
    private Animation slideUp, slideDown, slideLeft;
    private int count = 1;



    public StoreAndIndustryFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static StoreAndIndustryFragment newInstance() {
        return new StoreAndIndustryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_store_and_industry, container, false);
        imageView = view.findViewById(R.id.image);
        imageViewPhone = view.findViewById(R.id.image_phone);
        imageViewWallet = view.findViewById(R.id.image_industries);
        slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down_less);
        slideLeft = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
//        imageView.setVisibility(View.GONE);
//        imageViewWallet.setVisibility(View.GONE);
//        imageViewPhone.setVisibility(View.GONE);


        return view;
    }
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser && count ==1) {
            imageView.setVisibility(View.VISIBLE);
            imageViewWallet.setVisibility(View.VISIBLE);
            imageViewPhone.setVisibility(View.VISIBLE);
            imageView.startAnimation(slideLeft);
            imageViewWallet.startAnimation(slideUp);
            imageViewPhone.startAnimation(slideDown);
            count --;
        }
        else {
        }
        if (isVisibleToUser){
            ((WalkThroughActivity) getActivity()).changeDetails("StoreAndIndustryFragment","InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment");
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}