package com.cloudasset.motionlayout;

import androidx.recyclerview.widget.RecyclerView;

import com.cloudasset.motionlayout.databinding.ProductDescriptionImagesBinding;


class ImageViewHolder extends RecyclerView.ViewHolder{
    public ProductDescriptionImagesBinding productDescriptionImagesBinding;

    public ImageViewHolder(ProductDescriptionImagesBinding productDescriptionImagesBinding) {
        super(productDescriptionImagesBinding.getRoot());
        this.productDescriptionImagesBinding = productDescriptionImagesBinding;
    }

}
