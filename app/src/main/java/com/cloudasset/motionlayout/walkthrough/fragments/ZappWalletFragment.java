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

public class ZappWalletFragment extends Fragment {
    private boolean visible;
    private int count = 1;


    public ZappWalletFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ZappWalletFragment newInstance() {
        return new ZappWalletFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_zapp_wallet, container, false);
        ImageView imageView = view.findViewById(R.id.image);
        ImageView imageViewPhone = view.findViewById(R.id.image_phone);
        ImageView imageViewWallet = view.findViewById(R.id.image_wallet);
        TextView textView = view.findViewById(R.id.txtView_skip);
        Animation slideUp = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up);
        Animation slideDown = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down);
        Animation slideDownLess = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down_less);
        Animation slideLeft = AnimationUtils.loadAnimation(getContext(), R.anim.slide_left);
        imageView.startAnimation(slideLeft);
        imageViewWallet.startAnimation(slideUp);
        imageViewPhone.startAnimation(slideDownLess);
        textView.startAnimation(slideDown);
        return view;
    }

    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        visible = isVisibleToUser;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (visible) {
                    ((WalkThroughActivity) getActivity()).changeDetails("ZappWalletFragment", "InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment InstanceUpdateFragment");
                }
            }
        }, 1000);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}